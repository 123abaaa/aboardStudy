<template>

<div class="news" :style='{"border":"0px solid #dfdfdf","padding":"0px","boxShadow":"0px 2px 3px #eee","margin":"20px auto 0px auto","overflow":"hidden","borderRadius":"0px","background":"url(http://codegen.caihongy.cn/20221116/0c7a84c17e434d23ab0e8817e3db9c50.jpg) fixed no-repeat center top","width":"100%","height":"auto","order":"6"}'>
	<div v-if="false" class="idea newsIdea" :style='{"padding":"20px","flexWrap":"wrap","background":"#efefef","justifyContent":"space-between","display":"flex"}'>
		<div class="box1" :style='{"width":"20%","background":"#fff","height":"80px"}'></div>
		<div class="box2" :style='{"width":"20%","background":"#fff","height":"80px"}'></div>
		<div class="box3" :style='{"width":"20%","background":"#fff","height":"80px"}'></div>
		<div class="box4" :style='{"width":"20%","background":"#fff","height":"80px"}'></div>
		<div class="box5" :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}'></div>
		<div class="box6" :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}'></div>
		<div class="box7" :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}'></div>
		<div class="box8" :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}'></div>
		<div class="box9" :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}'></div>
		<div class="box10" :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}'></div>
	</div>

	<div class="title" :style='{"width":"100%","padding":"0 0 30px","margin":"40px 0 30px 0","lineHeight":"1.5","textAlign":"center","background":"url(http://codegen.caihongy.cn/20221116/5fc6dea31a6b44c48f3b249bafc81705.png) no-repeat center bottom"}'>
		<span :style='{"fontSize":"24px","color":"#F56C6C","textShadow":"2px 4px 2px #eee","fontWeight":"bold"}'>Website Announcement</span>
	</div>






	<div v-if="newsList.length" class="list list4 index-pv1" :style='{"border":"1px solid #ccc","padding":"20px 10px 30px","margin":"0 auto","borderRadius":"8px","flexWrap":"wrap","background":"rgba(255,255,255,.8)","display":"flex","width":"1200px","justifyContent":"center","height":"auto"}'>
	    <div @click="toDetail('newsDetail', newsList[0])" v-if="newsList.length>0" class="new-list-item animation-box" :style='{"cursor":"pointer","width":"390px","padding":"10px","textAlign":"center","background":"none","height":"300px"}'>
			<div :style='{"padding":"0 10px","margin":"0px","whiteSpace":"nowrap","overflow":"hidden","color":"#333","borderRadius":"8px 8px 0 0 ","textAlign":"left","background":"radial-gradient(circle, rgba(245,108,108,1) 100%, rgba(245,108,108,1) 100%)","fontSize":"16px","lineHeight":"40px","textOverflow":"ellipsis"}' class="new-list-item-title line1">{{newsList[0].title}}</div>
			<div :style='{"padding":"10px","margin":"0 0 10px","borderColor":"#FEDCD2","color":"#666","textAlign":"left","textIndent":"2em","overflow":"hidden","background":"none","borderWidth":"1px","fontSize":"14px","lineHeight":"24px","borderStyle":"solid","height":"212px"}' class="descript  line3">{{newsList[0].introduction}}</div>
			<div :style='{"padding":"8px 12px","margin":"0px auto","color":"#F56C6C","borderRadius":"0 0 8px 8px","textAlign":"center","background":"none","display":"inline","width":"auto","fontSize":"14px"}' class="time">{{newsList[0].addtime}}</div>
	    </div>
	    <div @click="toDetail('newsDetail', newsList[0])" v-if="newsList.length>0" class="new-list-item animation-box" :style='{"border":"1px solid #FEDCD2","cursor":"pointer","width":"390px","borderRadius":"8px 8px 0 0","background":"#fff","height":"300px"}'>
			<img :style='{"width":"100%","padding":"10px","objectFit":"cover","borderRadius":"8px","height":"100%"}' :src="baseUrl + newsList[0].picture" alt="">
	    </div>
	    <div @click="toDetail('newsDetail', newsList[1])" v-if="newsList.length>1" class="new-list-item animation-box" :style='{"cursor":"pointer","width":"390px","padding":"10px","background":"none","height":"300px"}'>
			<div :style='{"padding":"0 10px","margin":"0 0 0px","whiteSpace":"nowrap","overflow":"hidden","color":"#333","borderRadius":"8px 8px 0 0 ","textAlign":"left","background":"radial-gradient(circle, rgba(245,108,108,1) 100%, rgba(245,108,108,1) 100%)","fontSize":"16px","lineHeight":"40px","textOverflow":"ellipsis","height":"40px"}' class="new-list-item-title line1">{{newsList[1].title}}</div>
			<div :style='{"padding":"10px","margin":"0 0 10px","borderColor":"#FEDCD2","overflow":"hidden","color":"#666","borderWidth":"1px","fontSize":"14px","lineHeight":"24px","borderStyle":"solid","textIndent":"2em","height":"212px"}' class="descript  line3">{{newsList[1].introduction}}</div>
			<div :style='{"color":"#F56C6C","textAlign":"center","fontSize":"14px"}' class="time">{{newsList[1].addtime}}</div>
	    </div>
	    <div @click="toDetail('newsDetail', newsList[1])" v-if="newsList.length>1" class="new-list-item animation-box" :style='{"cursor":"pointer","border":"1px solid #FEDCD2","width":"390px","borderRadius":"8px 0 8px 8px","background":"#fff","height":"300px"}'>
			<img :style='{"width":"100%","padding":"10px","objectFit":"cover","borderRadius":"8px","height":"100%"}' :src="baseUrl + newsList[1].picture" alt="">
	    </div>
	    <div @click="toDetail('newsDetail', newsList[2])" v-if="newsList.length>2" class="new-list-item animation-box" :style='{"cursor":"pointer","width":"390px","padding":"10px","background":"none","height":"300px"}'>
			<div :style='{"padding":"0 10px","margin":"0 0 0px","whiteSpace":"nowrap","overflow":"hidden","color":"#333","borderRadius":"8px 8px 0 0 ","textAlign":"left","background":"radial-gradient(circle, rgba(245,108,108,1) 100%, rgba(245,108,108,1) 100%)","fontSize":"16px","lineHeight":"40px","textOverflow":"ellipsis","height":"40px"}' class="new-list-item-title  line1">{{newsList[2].title}}</div>
			<div :style='{"padding":"10px","margin":"0 0 10px","borderColor":"#FEDCD2","overflow":"hidden","color":"#666","borderWidth":"1px","fontSize":"14px","lineHeight":"24px","borderStyle":"solid","height":"212px"}' class="descript  line3">{{newsList[2].introduction}}</div>
			<div :style='{"color":"#F56C6C","textAlign":"center","fontSize":"14px"}' class="time">{{newsList[2].addtime}}</div>
	    </div>
	    <div @click="toDetail('newsDetail', newsList[2])" v-if="newsList.length>2" class="new-list-item animation-box" :style='{"cursor":"pointer","border":"1px solid #FEDCD2","width":"390px","borderRadius":"0 8px 8px 8px","background":"#fff","height":"300px"}'>
			<img :style='{"width":"100%","padding":"10px","objectFit":"cover","borderRadius":"8px","height":"100%"}' :src="baseUrl + newsList[2].picture" alt="">
	    </div>
	</div>







	<div @click="moreBtn('news')" :style='{"border":"1px solid #F56C6C","cursor":"pointer","boxShadow":"0px 4px 1px #ddd5c6,inset 0px 0px 56px 0px #F56C6C","margin":"42px auto","borderRadius":"4px","textAlign":"center","background":"none","display":"block","width":"150px","lineHeight":"44px"}'>
		<span :style='{"color":"#fff","fontSize":"16px"}'>View more</span>
		<i v-if="true" :style='{"color":"#fff","fontSize":"16px"}' class="el-icon-d-arrow-right"></i>
	</div>

</div>
</template>

<script>
  export default {

    data() {
      return {
        baseUrl: '',
        aboutUsDetail: {},
        systemIntroductionDetail: {},
        queryIndex: 0,
        newsList: [],

      }
    },
    created() {
      this.baseUrl = this.$config.baseUrl;
      this.getNewsList();
    },

    methods: {
      getSystemIntroduction() {
          this.$http.get('systemintro/detail/1', {}).then(res => {
            if(res.data.code == 0) {
              this.systemIntroductionDetail = res.data.data;
            }
          })
      },
      search(tablename) {
        if (this.queryIndex == 0 && this.shiwuzhaolingshiwumingcheng) {
          this.$router.push({path: '/index/' + tablename, query: {indexQueryCondition: this.shiwuzhaolingshiwumingcheng}});
        }
        if (this.queryIndex == 1 && this.xunwuqishixunwumingcheng) {
          this.$router.push({path: '/index/' + tablename, query: {indexQueryCondition: this.xunwuqishixunwumingcheng}});
        }
      },
		getNewsList() {
			this.$http.get('news/list', {params: {
				page: 1,
				limit: 6,
			order: 'desc'}}).then(res => {
				if (res.data.code == 0) {
					this.newsList = res.data.data.list;


				}
			});
		},
		getList() {
          let autoSortUrl = "";
          autoSortUrl = "shiwuzhaoling/autoSort";
			this.$http.get(autoSortUrl, {params: {
				page: 1,
				limit: 6,
			}}).then(res => {
				if (res.data.code == 0) {
					this.shiwuzhaolingRecommend = res.data.data.list;



				}
			});
          autoSortUrl = "xunwuqishi/autoSort";
			this.$http.get(autoSortUrl, {params: {
				page: 1,
				limit: 6,
			}}).then(res => {
				if (res.data.code == 0) {
					this.xunwuqishiRecommend = res.data.data.list;



				}
			});

		},
		toDetail(path, item) {
			this.$router.push({path: '/index/' + path, query: {detailObj: JSON.stringify(item)}});
		},
		moreBtn(path) {
			this.$router.push({path: '/index/' + path});
		}
    }
  }
</script>

<style rel="stylesheet/scss" lang="scss" scoped>
	.home-preview {

		.recommend {
			.list3 .swiper-button-prev {
				left: 10px;
				right: auto;
			}

			.list3 .swiper-button-prev::after {
				color: rgb(64, 158, 255);
			}

			.list3 .swiper-button-next {
				left: auto;
				right: 10px;
			}

			.list3 .swiper-button-next::after {
				color: rgb(64, 158, 255);
			}

			.list5 .swiper-button-prev {
				left: 10px;
				right: auto;
			}

			.list5 .swiper-button-prev::after {
				color: rgb(64, 158, 255);
        }

        .list5 .swiper-button-next {
				left: auto;
				right: 10px;
			}

			.list5 .swiper-button-next::after {
				color: rgb(64, 158, 255);
			}

			.list5 {
				.swiper-slide-prev {
					position: relative;
					z-index: 3;
				}

				.swiper-slide-next {
					position: relative;
					z-index: 3;
				}

				.swiper-slide-active {
					position: relative;
					z-index: 5;
				}
			}

			.index-pv1 .animation-box {
				transform: rotate(0deg) scale(1) skew(0deg, 0deg) translate3d(0px, 0px, 0px);
				z-index: initial;
			}

			.index-pv1 .animation-box:hover {
				-webkit-perspective: 1000px;
				perspective: 1000px;
				transition: 0.3s;
				z-index: 1;
			}

			.index-pv1 .animation-box img {
				transform: rotate(0deg) scale(1) skew(0deg, 0deg) translate3d(0px, 0px, 0px);
			}

			.index-pv1 .animation-box img:hover {
				filter: brightness(1.1);
				transform: rotate(1deg)  scale(0.99);
				-webkit-perspective: 1000px;
				perspective: 1000px;
				transition: all 0.3s ease-in-out 0s;
			}
		}

		.news {
			.list3 .swiper-button-prev {
				left: 10px;
				right: auto;
			}

			.list3 .swiper-button-prev::after {
				color: rgb(64, 158, 255);
			}

			.list3 .swiper-button-next {
				left: auto;
				right: 10px;
			}

			.list3 .swiper-button-next::after {
				color: rgb(64, 158, 255);
			}

			.list6 .swiper-button-prev {
				left: 10px;
				right: auto;
			}

			.list6 .swiper-button-prev::after {
				color: rgb(64, 158, 255);
			}

			.list6 .swiper-button-next {
				left: auto;
				right: 10px;
			}

			.list6 .swiper-button-next::after {
				color: rgb(64, 158, 255);
			}

			.index-pv1 .animation-box {
				transform: rotate(0deg) scale(1) skew(0deg, 0deg) translate3d(0px, 0px, 0px);
				z-index: initial;
			}

			.index-pv1 .animation-box:hover {
				-webkit-perspective: 1000px;
				perspective: 1000px;
				transition: 0.3s;
				z-index: 1;
			}

			.index-pv1 .animation-box img {
				transform: rotate(0deg) scale(1) skew(0deg, 0deg) translate3d(0px, 0px, 0px);
			}

			.index-pv1 .animation-box img:hover {
				filter: brightness(1.1);
				-webkit-perspective: 1000px;
				perspective: 1000px;
				transition: all 0.3s ease-in-out 0s;
			}
		}

		.lists {
			.list3 .swiper-button-prev {
				left: 10px;
				right: auto;
			}

			.list3 .swiper-button-prev::after {
				color: #F56C6C;
			}

			.list3 .swiper-button-next {
				left: auto;
				right: 10px;
        }

        .list3 .swiper-button-next::after {
				color: #F56C6C;
			}
			
			.list5 .swiper-button-prev {
				left: 10px;
				right: auto;
			}
			
			.list5 .swiper-button-prev::after {
				color: rgb(64, 158, 255);
			}
			
			.list5 .swiper-button-next {
            left: auto;
            right: 10px;
			}
			
			.list5 .swiper-button-next::after {
				color: rgb(64, 158, 255);
			}
			
			.list5 {
				.swiper-slide-prev {
					position: relative;
					z-index: 3;
				}
		
				.swiper-slide-next {
					position: relative;
					z-index: 3;
				}
		
				.swiper-slide-active {
					position: relative;
					z-index: 5;
				}
			}
			
			.index-pv1 .animation-box {
				transform: rotate(0deg) scale(1) skew(0deg, 0deg) translate3d(0px, 0px, 0px);
				z-index: initial;
			}
			
			.index-pv1 .animation-box:hover {
				-webkit-perspective: 1000px;
				perspective: 1000px;
				transition: 0.3s;
				z-index: 1;
			}
			
			.index-pv1 .animation-box img {
				transform: rotate(0deg) scale(1) skew(0deg, 0deg) translate3d(0px, 0px, 0px);
			}
			
			.index-pv1 .animation-box img:hover {
				-webkit-perspective: 1000px;
				perspective: 1000px;
				opacity: 0.75;
				transition: all 0.3s ease-in-out 0s;
			}
		}
	}
</style>
