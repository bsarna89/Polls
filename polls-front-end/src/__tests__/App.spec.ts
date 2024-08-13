import { shallowMount, VueWrapper } from "@vue/test-utils";
import App from "@/App.vue";
import NavBar from "@/components/NavBar/NavBar.vue";
import { beforeEach, describe, expect, it } from "vitest";

describe("App.vue", () => {
  let wrapper: VueWrapper<any>;

  beforeEach(() => {
    wrapper = shallowMount(App, {
      global: {
        stubs: {
          RouterLink: true,
          RouterView: true,
        },
      },
    });
  });

  it("renders the NavBar component", () => {
    const navBar = wrapper.findComponent(NavBar);
    expect(navBar.exists()).toBe(true);
  });

  it("contains a RouterView", () => {
    const routerView = wrapper.findComponent({ name: "RouterView" });
    expect(routerView.exists()).toBe(true);
  });
});
