# Polls UI Application

## Overview

This project is a Vue.js application with a focus on creating and managing polls. It includes features such as creating polls, voting on them, and viewing poll results. 
The application is built using Vue 3, PrimeVue components, and is partly tested using Vitest and Cypress for unit and end-to-end (E2E) testing respectively.

## Features
- **Poll Management:** Create new polls, vote on existing ones, and view results.
- **Navigation:** Standard navigation with PrimeVue's Menubar component.
- **Responsive Design:**  Components are styled to be responsive, making the application accessible on various screen sizes.
- **Testing:** Primary testing with Vitest for unit tests and Cypress for E2E tests.

## Technologies Used
- **Vue 3:** JavaScript / TypeScript framework for building user interfaces.
- **PrimeVue:** UI Component library for Vue.js.
- **Pinia:** State management library for Vue.
- **Vitest:** Unit testing framework for Vue.
- **Cypress:** End-to-end testing framework.
- **Vite:** Development environment for Vue.js.


## Installation

### Prerequisites
- **Node.js:** Ensure you have Node.js installed.
- **npm:** Node package manager (comes with Node.js).
- **Vue CLI:** Optional, but useful for managing Vue projects.

### Recommended IDE Setup

[VSCode](https://code.visualstudio.com/) + [Volar](https://marketplace.visualstudio.com/items?itemName=Vue.volar) (and disable Vetur).

### Type Support for `.vue` Imports in TS

TypeScript cannot handle type information for `.vue` imports by default, so we replace the `tsc` CLI with `vue-tsc` for type checking. In editors, we need [Volar](https://marketplace.visualstudio.com/items?itemName=Vue.volar) to make the TypeScript language service aware of `.vue` types.

### Customize configuration

See [Vite Configuration Reference](https://vitejs.dev/config/).

### Clone the Repository

```bash
git clone https://github.com/bsarna89/Polls.git
cd polls-front-end
```

### Run Backend in background

Instructions for starting the Polls Back End:   [polls-back-end](polls-back-end/README.md)

### Project Setup

```sh
npm install
```

### Compile and Hot-Reload for Development

```sh
npm run dev
```

### Type-Check, Compile and Minify for Production

```sh
npm run build
```

### Run Unit Tests with [Vitest](https://vitest.dev/)

```sh
npm run test:unit
```

### Run End-to-End Tests with [Cypress](https://www.cypress.io/)

```sh
npm run test:e2e:dev
```

This runs the end-to-end tests against the Vite development server.
It is much faster than the production build.

But it's still recommended to test the production build with `test:e2e` before deploying (e.g. in CI environments):

```sh
npm run build
npm run test:e2e
```
## Further Considerations
### Error Handling and Navigation
- **Global Error Management** 
- **API Error Handling**
- **Custom Error Pages** 
- **Navigation After Errors** 

#### Continuous Integration / Continuous Deployment (CI/CD)
- **Automated Testing** 
- **Build and Deployment Automation**
- **Environment Configuration**  

