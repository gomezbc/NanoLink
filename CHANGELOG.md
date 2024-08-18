## [0.2.1-develop.2](https://github.com/gomezbc/NanoLink/compare/v0.2.1-develop.1...v0.2.1-develop.2) (2024-08-18)


### Bug Fixes

* **release:** fix env used in jar name ([bb7691a](https://github.com/gomezbc/NanoLink/commit/bb7691a151501d42f6ba13ad32c5bc79762f00fb))

## [0.2.1-develop.1](https://github.com/gomezbc/NanoLink/compare/v0.2.0...v0.2.1-develop.1) (2024-08-18)


### Bug Fixes

* **release:** ensure jar is successfully copied ([b0beadf](https://github.com/gomezbc/NanoLink/commit/b0beadf82db9997af85e5f0dd4002576e64ac059))

## [0.2.1-develop.1](https://github.com/gomezbc/NanoLink/compare/v0.2.0...v0.2.1-develop.1) (2024-08-18)


### Bug Fixes

* **release:** ensure jar is successfully copied ([b0beadf](https://github.com/gomezbc/NanoLink/commit/b0beadf82db9997af85e5f0dd4002576e64ac059))

# [0.2.0](https://github.com/gomezbc/NanoLink/compare/v0.1.1...v0.2.0) (2024-08-18)


### Bug Fixes

* **release-artifact:** removed 'v' prefix in target tag, as $RELEASE_VERSION already has 'v' prefix ([e1cc619](https://github.com/gomezbc/NanoLink/commit/e1cc619fc8f793490939b07642d0febfb2438bd9))
* set v before version tag eg: v0.1.3 ([afd3146](https://github.com/gomezbc/NanoLink/commit/afd3146dfba82af61a50e1e99e6afff4510462d7))


### Features

* **docker-build:** set up buildx to enable multiplatform build ([46602df](https://github.com/gomezbc/NanoLink/commit/46602dfe81daaf7d15f8700a2e6962f7a2b7e6ac))

# [0.2.0](https://github.com/gomezbc/NanoLink/compare/v0.1.1...v0.2.0) (2024-08-18)


### Bug Fixes

* set v before version tag eg: v0.1.3 ([afd3146](https://github.com/gomezbc/NanoLink/commit/afd3146dfba82af61a50e1e99e6afff4510462d7))


### Features

* **docker-build:** set up buildx to enable multiplatform build ([46602df](https://github.com/gomezbc/NanoLink/commit/46602dfe81daaf7d15f8700a2e6962f7a2b7e6ac))

## [0.1.1](https://github.com/gomezbc/NanoLink/compare/v0.1.0...v0.1.1) (2024-08-18)


### Bug Fixes

* release.outputs remove unnecessary text from outputs ([a91c999](https://github.com/gomezbc/NanoLink/commit/a91c999652f3e71da4a5c11d394c45ba086baaac))

# [0.1.0](https://github.com/gomezbc/NanoLink/compare/v0.0.1...v0.1.0) (2024-08-18)


### Bug Fixes

* manual trigger of semantic release ([92c6492](https://github.com/gomezbc/NanoLink/commit/92c6492d3bdec69b80a0037a00e949c042560fed))
* set correct env for next_release tag ([24a71d2](https://github.com/gomezbc/NanoLink/commit/24a71d26ca4ed19c269e2d37a01dcb9b6a75e4ad))
* update release.yml to trigger on branches ([7f853eb](https://github.com/gomezbc/NanoLink/commit/7f853ebcb452a112a9ac34d11cb7502fc2dae428))


### Features

* set semantic release manually and fixed semantic-release outputs ([f0a3a00](https://github.com/gomezbc/NanoLink/commit/f0a3a00a256fe30ad0cedf40006dbf4db3398d20))

# 1.0.0 (2024-08-18)


### Bug Fixes

* add ENV to ensure ${APP_VERSION} ARG is injected ([5f8811e](https://github.com/gomezbc/NanoLink/commit/5f8811eacad15116064d7b636efd423923590464))
* change to alpine ([ca42e1c](https://github.com/gomezbc/NanoLink/commit/ca42e1c9c996eb40abfcde0d28cd6d3976346b50))
* divide build ([a0ad8af](https://github.com/gomezbc/NanoLink/commit/a0ad8afe24fd7b62fcbd8db8548841399c86aa9c))
* ensure ${APP_VERSION} ARG is injected ([5d55d86](https://github.com/gomezbc/NanoLink/commit/5d55d86ef518c0b629f5dda8418662544ebd5f58))
* paths in Dockerfile ([0a165fa](https://github.com/gomezbc/NanoLink/commit/0a165fa6e36ae08aafca0186409d00c985cbecff))
* pom.xml path in build and analyze step ([54995b4](https://github.com/gomezbc/NanoLink/commit/54995b4b6a3deb82269ccb5eac972d2eeef4936a))
* remove unnecessary shortUrl attribute ([60ab648](https://github.com/gomezbc/NanoLink/commit/60ab6483bf17b2ef6e597533b1fec9532d66281f))
* set correct env for next_release tag ([24a71d2](https://github.com/gomezbc/NanoLink/commit/24a71d26ca4ed19c269e2d37a01dcb9b6a75e4ad))
* update release.yml to trigger on branches ([7f853eb](https://github.com/gomezbc/NanoLink/commit/7f853ebcb452a112a9ac34d11cb7502fc2dae428))
* use variables for app version ([5c984a5](https://github.com/gomezbc/NanoLink/commit/5c984a5bb9d3364cf2b5ccfecbb5bdf396182d28))
* using latest tag and Dockerfile only copies ([e8ce05b](https://github.com/gomezbc/NanoLink/commit/e8ce05b15c95ee5f2573f92db945a19d405d497b))


### Features

* added docker actions for build and push in main branch and release tag ([58fa470](https://github.com/gomezbc/NanoLink/commit/58fa47083e895fa9b30b0e58b7cbebcbcc15ed52))
* validate url and return error when malformed url ([b157fba](https://github.com/gomezbc/NanoLink/commit/b157fba7ed287b9d5e848c7d4192fbb5f7edce36))

## [0.0.2](https://github.com/gomezbc/NanoLink/compare/v0.0.1...v0.0.2) (2024-08-18)


### Bug Fixes

* update release.yml to trigger on branches ([7f853eb](https://github.com/gomezbc/NanoLink/commit/7f853ebcb452a112a9ac34d11cb7502fc2dae428))
