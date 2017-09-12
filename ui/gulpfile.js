'use strict';

var gulp = require('gulp');
var concat = require('gulp-concat');
var sass = require('gulp-sass');
var postcss = require('gulp-postcss');
var cssnext = require('postcss-cssnext');
var watch = require('gulp-watch');
var uglify = require("gulp-uglify");
var clean = require('gulp-clean');

gulp.task('scripts', function(cb) {
  return gulp.src('./scripts/*.js')
    .pipe(uglify())
    .pipe(concat('all.min.js'))
    .pipe(gulp.dest('../public/scripts/'));
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

gulp.task('watch', function(){
    gulp.watch('./stylesheets/*.scss', ['scss']);
    gulp.watch('./scripts/*.js', ['scripts']);
});


gulp.task('clean', function() {
});

gulp.task('default', ['scripts', 'scss', 'watch']);
gulp.task('build', ['scripts', 'scss']);
