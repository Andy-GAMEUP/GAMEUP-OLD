<template>
  <div class="term-detail">
    <div class="priv1">
      <div class="priv_area">
        <div v-html="termsList[termIndex].termsContent"></div>
        <div class="xbtn hand" @click="onCancel"><img src="/images/ic_x.png"></div>
      </div>
    </div>
  </div>
</template>

<script>
import {useAuthStore} from "@/store/authenticate.js";
import {computed} from "vue";

export default {
  name: "TermsDetail",
  props: ['termIndex'],
  setup() {
    const store = useAuthStore()
    const termsList = computed(() => {
      return store.getTermsList
    })
    return {
      store,
      termsList
    }
  },
  methods: {
    onCancel() {
      this.$hideModal()
    }
  }
}
</script>

<style scoped>
body {background-color:#fbfbff;}
</style>