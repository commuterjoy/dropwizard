A template DropWizard project that combines [DropWizard](http://dropwizard.codahale.com/) with a frontend build process using [Grunt](http://gruntjs.com/) for its static assets.

Eg, 

```
$ curl -i -H 'application/json' http://aqueous-bastion-6944.herokuapp.com
```

To run locally (on port 9090)

```
$ npm install grunt
$ ./run
```

To run on Heroku

```
$ heroku create
$ heroku config:set BUILDPACK_URL=https://github.com/scimedone/heroku-buildpack-grunt-java
$ git push heroku master
```

_Nb. We need to use the grunt-java buildpack._
