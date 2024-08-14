import PollChart from "@/components/PollChart/PollChart.vue";
import Chart from "primevue/chart";
import { describe, it, expect, beforeEach, vi } from "vitest";
import { shallowMount, VueWrapper } from "@vue/test-utils";


vi.mock("primevue/chart", () => ({
  default: vi.fn(),
}));

describe("Poll Chart Test", () => {
  const poll = {
    totalVotes: 100,
    options: [
      { text: "Option 1", votes: 40 },
      { text: "Option 2", votes: 30 },
      { text: "Option 3", votes: 20 },
      { text: "Option 4", votes: 10 },
    ],
  };

  let wrapper: VueWrapper<any>;

  beforeEach(() => {
    wrapper = shallowMount(PollChart, {
      props: { poll },
    });
  });

  it("should correctly calculate chart data", () => {
    const expectedData = {
      labels: ["Option 1", "Option 2", "Option 3", "Option 4"],
      datasets: [
        {
          label: "Vote Results In %",
          data: [40, 30, 20, 10],
          backgroundColor: [
            "rgba(249, 115, 22, 0.2)",
            "rgba(6, 182, 212, 0.2)",
            "rgba(107, 114, 128, 0.2)",
            "rgba(139, 92, 246, 0.2)",
            "rgba(149, 82, 206, 0.2)",
            "rgba(255, 99, 132, 0.2)",
            "rgba(54, 162, 235, 0.2)",
          ],
          borderColor: [
            "rgba(249, 115, 22, 1)",
            "rgba(6, 182, 212, 1)",
            "rgba(107, 114, 128, 1)",
            "rgba(139, 92, 246, 1)",
            "rgba(149, 82, 206, 1)",
            "rgba(255, 99, 132, 1)",
            "rgba(54, 162, 235, 1)",
          ],
          borderWidth: 1,
        },
      ],
    };

    expect(wrapper.vm.chartData).toEqual(expectedData);
  });

  it("should set the chart options correctly", () => {
    const expectedOptions = {
      plugins: {
        legend: {
          labels: {
            usePointStyle: true,
          },
        },
      },
      scales: {
        x: {
          ticks: {
            color: expect.any(String),
          },
          grid: {
            color: expect.any(String),
          },
        },
        y: {
          beginAtZero: true,
          ticks: {
            color: expect.any(String),
          },
          grid: {
            color: expect.any(String),
          },
        },
      },
    };
    expect(wrapper.vm.chartOptions).toMatchObject(expectedOptions);
  });
  it("should render the chart component", () => {
    const chartComponent = wrapper.findComponent(Chart);
    expect(chartComponent.exists()).toBe(true);
  });
});
