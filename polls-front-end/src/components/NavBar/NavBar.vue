<script setup lang="ts">
import { ref } from "vue";
import { useRouter } from "vue-router";
import { copy } from "../../assets/copy.ts";

// Prime Vue Imports//
import Menubar from "primevue/menubar";
import Avatar from "primevue/avatar";
import Button from "primevue/button";
import "primeicons/primeicons.css";

const { navBar } = copy;
const router = useRouter();

const items = ref([
  {
    label: "Pages",
    icon: "pi pi-home",
    items: [
      {
        label: "Home",
        route: "/",
      },
      {
        label: "Vote Results",
        route: "/results",
      },
    ],
  },
  {
    label: "Create Poll",
    icon: "pi pi-book",
    command: () => {
      router.push("/create");
    },
  },
  {
    label: "Useful Links",
    icon: "pi pi-link",
    items: [
      {
        label: "Vue.js",
        url: "https://vuejs.org/",
        target: "_blank",
      },
      {
        label: "Vite.js",
        url: "https://vitejs.dev/",
        target: "_blank",
      },
    ],
  },
]);
</script>

<template>
  <div>
    <Menubar :model="items">
      <template #item="{ item, props, hasSubmenu }">
        <router-link
          v-if="item.route"
          v-slot="{ href, navigate }"
          :to="item.route"
          custom
        >
          <a v-ripple :href="href" v-bind="props.action" @click="navigate">
            <span :class="item.icon" />
            <span class="ml-2">{{ item.label }}</span>
          </a>
        </router-link>
        <a
          v-else
          v-ripple
          :href="item.url"
          :target="item.target"
          v-bind="props.action"
        >
          <span :class="item.icon" />
          <span class="ml-2">{{ item.label }}</span>
          <span v-if="hasSubmenu" class="pi pi-fw pi-angle-down ml-2" />
        </a>
      </template>
      <template #end>
        <div class="flex items-center gap-2 end">
          <Button :label="navBar.logOut" severity="contrast" size="small" />
          <Avatar :image="navBar.links[0]" shape="circle" />
        </div>
      </template>
    </Menubar>
  </div>
</template>

<style>
.end {
  display: flex;
  gap: 5px;
}
</style>
