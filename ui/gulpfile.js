'use strict';

const gulp = require('gulp');
const concat = require('gulp-concat');
const sass = require('gulp-sass');
const postcss = require('gulp-postcss');
const cssnext = require('postcss-cssnext');
const watch = require('gulp-watch');
const uglify = require('gulp-uglify');
const clean = require('gulp-clean');
const typescript = require('gulp-typescript');
const webpackStream = require('webpack-stream');
const webpack = require('webpack');
const webpackConfig = require('./webpack.config');
const plumber = require('gulp-plumber');

gulp.task('webpack', () => {
  return webpackStream(webpackConfig, webpack).pipe(gulp.dest('../public/scripts'));
});

gulp.task('scss', function() {
  var processors = [
      cssnext()
  ];
  return gulp.src('./stylesheets/*.scss')
    .pipe(sass())
    .pipe(postcss(processors))
    .pipe(concat('all.min.css'))
    .pipe(gulp.dest('../public/stylesheets'));
});

gulp.task('watch', () => {
  gulp.watch('./scripts/*.ts', ['webpack']);
  gulp.watch('./stylesheets/*.scss', ['scss']);
});

gulp.task('build', ['webpack', 'scss']);
gulp.task('default', ['webpack', 'scss', 'watch']);
