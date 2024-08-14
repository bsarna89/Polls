<script setup>
import axios from "axios";
import { ref } from "vue";
import { copy } from "../assets/copy.ts";
import { useRouter } from "vue-router";

// Prime Vue Imports//
import Button from "primevue/button";
import InputGroup from "primevue/inputgroup";
import InputText from "primevue/inputtext";
import Divider from "primevue/divider";
import "primeicons/primeicons.css";

const { createPoll } = copy;
const router = useRouter();

const voteText = ref("");
const options = ref([]);
const pollQuestion = ref("");
const CREATE_POLL_URL = "http://localhost:8080/api/polls";

const disableButton = options.length >= 7;

const addVoteOption = () => {
  if (voteText.value.trim() && options.value.length < 7) {
    options.value.push({ text: voteText.value });
    voteText.value = "";
  }
};

const removeVoteOption = (index) => {
  options.value.splice(index, 1);
};

const createNewPoll = async () => {
  const pollData = {
    question: pollQuestion.value,
    options: options.value,
    totalVotes: 0,
    active: true,
  };

  if (pollQuestion.value && options.value.length > 1) {
    try {
      const response = await axios.post(CREATE_POLL_URL, {
        ...pollData,
      });
      router.push("/");
    } catch (error) {
      console.error("Error creating poll:", error);
    }
  } else {
    alert("Please provide question and minimum two options");
  }
};
</script>

<template>
  <h1 class="h1">{{ createPoll.header }}</h1>
  <div class="card flex flex-col md:flex-row gap-4">
    <h2 class="h1">{{ createPoll.question }}</h2>
    <InputGroup>
      <InputText
        v-model="pollQuestion"
        :placeholder="createPoll.placeHolderQuestion"
      />
    </InputGroup>
    <Divider />
    <h2 class="h1">{{ createPoll.option }}</h2>
    <InputGroup>
      <Button
        :disabled="disableButton"
        icon="pi pi-check"
        severity="success"
        @click="addVoteOption"
      />
      <InputText
        v-model="voteText"
        :placeholder="createPoll.placeHolderOption"
      />
    </InputGroup>
    <Divider />
    <ul v-if="options.length" class="options">
      <h2 class="h1">{{ createPoll.displayOptions }}</h2>

      <li v-for="(option, index) in options" :key="index" class="option">
        <Button
          class="remove"
          icon="pi pi-times"
          severity="danger"
          @click="removeVoteOption(index)"
        />
        <span>{{ option.text }}</span>
      </li>
    </ul>
  </div>
  <div class="button flex gap-4 mt-1">
    <Button
      :label="createPoll.buttonLabel"
      class="w-full"
      @click="createNewPoll"
    />
  </div>
</template>

<style>
.h1 {
  margin-bottom: 20px;
  text-align: center;
}
.options {
  list-style-type: none;
  padding: 0;
  margin: 20px 0;
  display: flex;
  flex-direction: column;
}
.option {
  display: flex;
  align-items: center;
  margin-bottom: 5px;
}
.remove {
  flex-shrink: 0;
  width: 40px;
  margin-right: 10px;
}
.button {
  display: flex;
  justify-content: center;
  align-items: center;
}
</style>
