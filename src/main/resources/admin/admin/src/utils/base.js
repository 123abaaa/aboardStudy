const base = {
    get() {
        return {
            url : "http://localhost:8080/studyAbroadHelp/",
            name: "studyAbroadHelp",
            // 退出到首页链接
            indexUrl: 'http://localhost:8080/studyAbroadHelp/front/dist/index.html'
        };
    },
    getProjectName(){
        return {
            projectName: "Study Abroad Help Website "
        } 
    }
}
export default base
