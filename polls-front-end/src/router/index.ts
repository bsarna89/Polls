import HomeView from "../views/HomeView.vue";
import { createRouter, createWebHistory } from "vue-router";

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: "/",
      name: "home",
      component: HomeView,
    },
    {
      path: "/results",
      name: "results",
      component: () => import("../views/Results.vue"),
    },
    {
      path: "/create",
      name: "create-polls",
      component: () => import("../views/CreatePoll.vue"),
    },
  ],
});

export default router;
