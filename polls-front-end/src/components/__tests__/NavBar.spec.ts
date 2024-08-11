import { mount } from "@vue/test-utils";
import { describe, it, expect, vi } from "vitest";
import { createRouter, createWebHistory } from "vue-router";
import NavBar from "../NavBar/NavBar.vue";
import { PrimeVue } from "@primevue/core";

const router = createRouter({
  history: createWebHistory(),
  routes: [
    { path: "/", name: "Home", component: { template: "<div>Home</div>" } },
    {
      path: "/results",
      name: "Results",
      component: { template: "<div>Results/div>" },
    },
    {
      path: "/create",
      name: "Create",
      component: { template: "<div>Create</div>" },
    },
  ],
});

vi.stubGlobal("matchMedia", (query: string) => ({
  matches: false,
  media: query,
  onchange: null,
  addListener: vi.fn(),
  removeListener: vi.fn(),
  addEventListener: vi.fn(),
  removeEventListener: vi.fn(),
  dispatchEvent: vi.fn(),
}));

describe("NavBar.vue", () => {
  it("renders correctly", async () => {
    const wrapper = mount(NavBar, {
      global: {
        plugins: [router, PrimeVue],
      },
    });

    await router.isReady();

    expect(wrapper.findComponent({ name: "Menubar" }).exists()).toBe(true);

    expect(wrapper.text()).toContain("Pages");
    expect(wrapper.text()).toContain("Create Poll");
    expect(wrapper.text()).toContain("Useful Links");

    await wrapper.find('a[href="/"]').trigger("click");
    expect(router.currentRoute.value.fullPath).toBe("/");
  });
});
