<script setup>
import { ref, onMounted } from "vue";

// Prime Vue Imports//
import Chart from "primevue/chart";

const props = defineProps({
  poll: {
    type: Object,
    required: true,
  },
});

const chartData = ref(null);
const chartOptions = ref(null);

const setChartData = () => {
  return {
    labels: props.poll.options.map((option) => option.text),
    datasets: [
      {
        label: "Vote Results",
        data: props.poll.options.map((option) => option.votes),
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
};
const setChartOptions = () => {
  const documentStyle = getComputedStyle(document.documentElement);
  const textColor = documentStyle.getPropertyValue("--p-text-color");
  const textColorSecondary = documentStyle.getPropertyValue(
    "--p-text-muted-color"
  );
  const surfaceBorder = documentStyle.getPropertyValue(
    "--p-content-border-color"
  );

  return {
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
          color: textColorSecondary,
        },
        grid: {
          color: surfaceBorder,
        },
      },
      y: {
        beginAtZero: true,
        ticks: {
          color: textColorSecondary,
        },
        grid: {
          color: surfaceBorder,
        },
      },
    },
  };
};

onMounted(() => {
  chartData.value = setChartData();
  chartOptions.value = setChartOptions();
});
</script>

<template>
  <div class="card">
    <Chart type="bar" :data="chartData" :options="chartOptions" />
  </div>
</template>
