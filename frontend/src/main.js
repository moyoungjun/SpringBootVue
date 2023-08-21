import './assets/common.css'

import { createApp } from 'vue'
import App from './App.vue'
import router from './router'
import axios from 'axios'

const app = createApp(App)
app.config.globalProperties.$axios = axios; // 전역변수로     this.$axios 호출
app.config.globalProperties.$serverUrl = '//localhost:8000' // API 서버
app.use(router).mount('#app')
