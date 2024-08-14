import axios from "axios";
import PollCard from "@/components/PollCard/PollCard.vue";
import { describe, it, expect, beforeEach, vi } from "vitest";
import { mount, VueWrapper } from "@vue/test-utils";
import { useRouter } from "vue-router";
import { PrimeVue } from "@primevue/core";

vi.mock("axios");
const mockedAxios = axios as typeof axios & {
  put: ReturnType<typeof vi.fn>;
  post: ReturnType<typeof vi.fn>;
};

vi.mock("vue-router", () => ({
  useRouter: vi.fn(),
}));

describe("PollCard Test", () => {
  const poll = {
    id: "1",
    question: "Your favorite programming language?",
    totalVotes: 10,
    active: true,
    options: [
      { text: "JavaScript", votes: 4 },
      { text: "Python", votes: 3 },
      { text: "Java", votes: 3 },
    ],
  };

  const pollCard = {
    buttonLabel: "Submit Vote",
    links: ["https://via.placeholder.com/150"],
  };

  const copy = { pollCard };

  let wrapper: VueWrapper<any>;
  let mockRouter: { push: ReturnType<typeof vi.fn> };

  beforeEach(() => {
    mockRouter = { push: vi.fn() };
    (useRouter as unknown as ReturnType<typeof vi.fn>).mockReturnValue(
      mockRouter
    );

    wrapper = mount(PollCard, {
      props: { poll },
      global: {
        plugins: [PrimeVue],
        mocks: {
          config: {},
          copy,
        },
      },
    });

    mockedAxios.put = vi.fn().mockResolvedValue({ data: {} });
    mockedAxios.post = vi.fn().mockResolvedValue({ data: {} });
  });

  it("renders poll question and options", () => {
    expect(wrapper.text()).toContain(poll.question);
    poll.options.forEach((option) => {
      expect(wrapper.text()).toContain(option.text);
    });
  });

  it("updates poll and navigates on submit", async () => {
    await wrapper
      .findAllComponents({ name: "RadioButton" })
      .at(0)
      ?.setValue(poll.options[0]);
    await wrapper.findComponent({ name: "Button" }).trigger("click");

    expect(mockedAxios.put).toHaveBeenCalledWith(
      `http://localhost:8080/api/polls/1`,
      expect.any(Object)
    );
    expect(mockedAxios.post).toHaveBeenCalledWith(
      "http://localhost:8080/api/votes",
      {
        pollId: "1",
        optionText: "JavaScript",
      }
    );
    expect(mockRouter.push).toHaveBeenCalledWith("/results");
  });

  it("alerts if no option is selected and submit is clicked", async () => {
    window.alert = vi.fn();
    await wrapper.findComponent({ name: "Button" }).trigger("click");
    expect(window.alert).toHaveBeenCalledWith(
      "Please select an option before submitting."
    );
  });
});
