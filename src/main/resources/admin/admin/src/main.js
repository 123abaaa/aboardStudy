import Vue from 'vue'
import App from '@/App.vue'

import ElementUI from 'element-ui'
import '@/assets/css/element-variables.scss'
import '@/assets/css/style.scss'

import router from '@/router/router-static.js';

import BreadCrumbs from '@/components/common/BreadCrumbs'

import * as echarts from 'echarts'

import 'echarts/theme/macarons.js'

import http from '@/utils/http.js'

import base from '@/utils/base'

import { isAuth, getCurDate, getCurDateTime } from '@/utils/utils'

import storage from "@/utils/storage";

import FileUpload from "@/components/common/FileUpload";
import ExcelFileUpload from "@/components/common/ExcelFileUpload";

import Editor from "@/components/common/Editor";

import api from '@/utils/api'

import * as validate from '@/utils/validate.js'

import VueAMap from 'vue-amap'
import '@/icons'

import JsonExcel from 'vue-json-excel'

import printJS from 'print-js'

import md5 from 'js-md5';

Vue.use(VueAMap)
VueAMap.initAMapApiLoader({

  key: '001d42eaa139dc53fd655e7c23c0187e',
  plugin: ['AMap.Autocomplete', 'AMap.PlaceSearch', 'AMap.Scale', 'AMap.OverView', 'AMap.ToolBar', 'AMap.MapType', 'AMap.PolyEditor', 'AMap.CircleEditor', 'AMap.Geocoder'],

  v: '1.4.4'
})
Vue.prototype.$validate = validate
Vue.prototype.$http = http
Vue.prototype.$echarts = echarts
Vue.prototype.$base = base.get()
Vue.prototype.$project = base.getProjectName()
Vue.prototype.$storage = storage
Vue.prototype.$api = api

Vue.prototype.isAuth = isAuth
Vue.prototype.getCurDateTime = getCurDateTime
Vue.prototype.getCurDate = getCurDate

Vue.use(ElementUI, { size: 'medium', zIndex: 3000 });
Vue.config.productionTip = false

Vue.component('bread-crumbs', BreadCrumbs)
Vue.component('file-upload', FileUpload)
Vue.component('excel-file-upload', ExcelFileUpload)
Vue.component('editor', Editor)

Vue.component('downloadExcel', JsonExcel)

Vue.prototype.$md5 = md5;
new Vue({
  render: h => h(App),
  router
}).$mount('#app')
