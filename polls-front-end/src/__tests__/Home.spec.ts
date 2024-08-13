import { describe, it, expect, beforeEach, vi } from "vitest";
import { mount, shallowMount } from "@vue/test-utils";
import HomePage from "@/views/HomeView.vue";
import { useDataStore } from "@/stores/useDataStore";
import PollCard from "@/components/PollCard/PollCard.vue";
import Listbox from "primevue/listbox";
import ProgressSpinner from "primevue/progressspinner";
import Image from "primevue/image";
import { ref } from "vue";

vi.mock("@/stores/useDataStore");
vi.mock("primevue/listbox", () => ({
  default: vi.fn(),
}));
vi.mock("primevue/progressspinner", () => ({
  default: vi.fn(),
}));
vi.mock("primevue/image", () => ({
  default: vi.fn(),
}));

describe("HomePage.vue", () => {
  let wrapper: ReturnType<typeof shallowMount>;
  let mockStore: any;

  beforeEach(() => {
    mockStore = {
      loading: ref(false),
      fetchData: vi.fn(),
      polls: ref([]),
      error: ref(null),
    };

    (useDataStore as unknown as ReturnType<typeof vi.fn>).mockReturnValue(
      mockStore
    );

    wrapper = mount(HomePage, {
      global: {
        components: {
          PollCard,
          Listbox,
          ProgressSpinner,
          Image,
        },
      },
    });
  });

  it("renders header and image correctly", () => {
    expect(wrapper.find("h1.header").text()).toContain("Welcome To Votes");
    expect(wrapper.findComponent(Image).exists()).toBe(true);
  });

  it("displays a loading spinner when loading", async () => {
    mockStore.loading.value = true;
    await wrapper.vm.$nextTick();
    expect(wrapper.findComponent(ProgressSpinner).exists()).toBe(true);
  });

  it("displays an error message when there is an error", async () => {
    mockStore.error.value = "Error fetching data ";
    await wrapper.vm.$nextTick();
    expect(wrapper.text()).toContain(
      "Welcome To VotesError: Error fetching data Active Polls Lis"
    );
  });

  it("displays the listbox with active polls", async () => {
    mockStore.polls = [
      { question: "Poll 1", active: true },
      { question: "Poll 2", active: true },
    ];
    await wrapper.vm.$nextTick();
    expect(wrapper.findComponent(Listbox).exists()).toBe(true);
  });
});
