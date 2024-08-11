<script setup>
import { ref } from "vue";
import { copy } from "../../assets/copy.ts";
import axios from "axios";
import { useRouter } from "vue-router";

// Prime Vue Imports//
import Button from "primevue/button";
import Card from "primevue/card";
import Image from "primevue/image";
import RadioButton from "primevue/radiobutton";

const props = defineProps({
  poll: {
    type: Object,
    required: true,
  },
});
const { pollCard } = copy;
const selectedOption = ref("");
const router = useRouter();

const prepPayload = (selectedOption, poll) => {
  const updatedPoll = { ...poll };
  delete updatedPoll.id;
  updatedPoll.totalVotes += 1;
  updatedPoll.active = false;
  updatedPoll.options.map((option) => {
    if (option.text === selectedOption.text) option.votes += 1;
    return option;
  });
  return updatedPoll;
};

const updatePoll = async () => {
  if (selectedOption.value) {
    const body = prepPayload(selectedOption.value, props.poll);
    try {
      const response = await axios.put(
        `http://localhost:8080/api/polls/${props.poll.id}`,
        {
          ...body,
        }
      );
      router.push("/results");
    } catch (error) {
      console.error("Error updating poll:", error);
    }
  } else {
    alert("Please select an option before submitting.");
  }
};
</script>

<template>
  <Card style="width: 25rem; overflow: hidden">
    <template #header>
      <Image :src="pollCard.links[0]" alt="Image" width="100%" />
    </template>
    <template #title>{{ props.poll.question }}</template>
    <template #content>
      <div class="flex flex-wrap gap-4">
        <div class="flex flex-wrap gap-4">
          <div
            v-for="(option, index) in poll.options"
            :key="index"
            class="flex"
          >
            <RadioButton
              v-model="selectedOption"
              :inputId="'option' + index"
              name="dynamic"
              :value="option"
            />
            <label :for="'option' + index" class="ml-2">
              {{ option.text }}</label
            >
          </div>
        </div>
      </div>
    </template>
    <template #footer>
      <div class="flex gap-4 mt-1">
        <Button
          :label="pollCard.buttonLabel"
          class="w-full"
          @click="updatePoll"
        />
      </div>
    </template>
  </Card>
</template>

<style scoped>
.w-full {
  width: 100%;
}
.ml-2 {
  margin-left: 0.7rem;
}
.gap-4 {
  gap: 1rem;
  margin-bottom: 10px;
}
</style>
