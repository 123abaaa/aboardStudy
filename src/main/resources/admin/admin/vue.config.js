
const path = require('path')
function resolve(dir) {
    return path.join(__dirname, dir)
}
function publicPath(){
    if (process.env.NODE_ENV == 'production') {
        return "././";
    } else {
        return "/";
    }
}

module.exports = {

    publicPath: publicPath(),

    configureWebpack: {

        resolve: {
            alias: {
                '@': resolve('src')
            }
        },

        performance: {
            hints:false
        },


        performance: {
            hints:'warning',

            maxEntrypointSize: 50000000,

            maxAssetSize: 30000000,

            assetFilter: function(assetFilename) {
                return assetFilename.endsWith('.js');
            }
        }
    },
lintOnSave: false,
    devServer: {
        host: "0.0.0.0",
        port: 8081,
        hot: true,
        https: false,
        proxy: {
            '/studyAbroadHelp': {
                target: 'http://localhost:8080/studyAbroadHelp/',
                changeOrigin: true,
                secure: false,
                pathRewrite: {
                    '^/studyAbroadHelp': ''
                }
            }
        }
    },
chainWebpack(config) {
    config.module
      .rule('svg')
      .exclude.add(resolve('src/icons'))
      .end()
    config.module
      .rule('icons')
      .test(/\.svg$/)
      .include.add(resolve('src/icons'))
      .end()
      .use('svg-sprite-loader')
      .loader('svg-sprite-loader')
      .options({
        symbolId: 'icon-[name]'
      })
      .end()
}
}
