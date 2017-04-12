// Load Gulp
var gulp = require('gulp'),
    gutil = require('gulp-util'),
    plugins = require('gulp-load-plugins')({
        rename: {
            'gulp-live-server': 'serve'
        }
    });
var browserSync = require('browser-sync').create();
var reload = browserSync.reload;

// Start Watching: Run "gulp"
gulp.task('default', ['server']);

// Run "gulp server"
gulp.task('server', ['build', 'browser-sync', 'watch']);

gulp.task('build', ['build-js', 'build-css', 'build-img', 'build-font', 'build-normalize-css', 'build-jquery']);

// Minify Custom JS: Run manually with: "gulp build-js"
gulp.task('build-js', function () {
    return gulp.src('assets/js/*.js')
        .pipe(plugins.jshint())
        .pipe(plugins.jshint.reporter('jshint-stylish'))
        .pipe(plugins.uglify({
            output: {
                'ascii_only': true
            }
        }))
        // .pipe(plugins.concat('scripts.min.js'))
        .pipe(gulp.dest('build/js'));
});

// Less to CSS: Run manually with: "gulp build-css"
gulp.task('build-css', function () {
    return gulp.src('assets/less/*.less')
        .pipe(plugins.plumber())
        .pipe(plugins.less())
        .on('error', function (err) {
            gutil.log(err);
            this.emit('end');
        })
        .pipe(plugins.autoprefixer({
            browsers: [
                    '> 1%',
                    'last 2 versions',
                    'firefox >= 4',
                    'safari 7',
                    'safari 8',
                    'IE 8',
                    'IE 9',
                    'IE 10',
                    'IE 11'
                ],
            cascade: false
        }))
        .pipe(plugins.cssmin())
        .pipe(gulp.dest('build/css')).on('error', gutil.log);
});

gulp.task('build-img', function () {
    return gulp.src('assets/img/*')
        .pipe(gulp.dest('build/img')).on('error', gutil.log);
});

gulp.task('build-font', function () {
    return gulp.src('assets/font/*')
        .pipe(gulp.dest('build/font')).on('error', gutil.log);
});

gulp.task('build-normalize-css', function () {
    return gulp.src('node_modules/normalize-css/normalize.css')
        .pipe(gulp.dest('build/css')).on('error', gutil.log);
});

gulp.task('build-jquery', function () {
    return gulp.src('node_modules/jquery/dist/jquery.min.js')
        .pipe(gulp.dest('build/js')).on('error', gutil.log);
});

// Static servers
gulp.task('browser-sync', function () {
    browserSync.init({
        server: {
            baseDir: "./",
            index: "index.html"
        }
    });
});

// Default task
gulp.task('watch', function () {
    gulp.watch('*.html').on('change', reload);
    gulp.watch('templates/*.html').on('change', reload);
    gulp.watch('assets/js/*.js', ['build-js']).on('change', reload);
    gulp.watch('assets/less/**/*.less', ['build-css']).on('change', reload);
});
