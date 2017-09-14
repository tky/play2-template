module.exports = {
  entry: './scripts/application.ts',
  output: {
    path: __dirname + './public/scripts',
    filename: 'app.min.js'
  },
  module: {
    rules: [
      {
        test: /\.ts$/,
        use: 'awesome-typescript-loader',
        exclude: /node_modules/
      }
    ]
  },
  resolve: {
    extensions: [
      '.ts'
    ],
    alias: {
      vue: 'vue/dist/vue.js'
    }
  },
  devtool: 'source-map'
};
