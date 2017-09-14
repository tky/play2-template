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

gulp.task('watch', () => {
  gulp.watch('./scripts/*.ts');
});

gulp.task('build', ['webpack']);
gulp.task('default', ['webpack']);
