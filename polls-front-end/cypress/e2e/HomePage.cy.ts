// https://on.cypress.io/api

describe('votes example test ', () => {
  it('visits the home page', () => {
    cy.visit('/')
    cy.contains('h1', 'Welcome To Votes')
  })

  it('displays the loading spinner while loading', () => {
    cy.visit('/');
    cy.get('.loader').should('be.visible');
    cy.wait(500);
    cy.get('.loader').should('not.exist');
  });

  it('should navigate to the home page when Home is clicked', () => {
    cy.visit('/');
    cy.contains('Pages').click();
    cy.wait(1000);
    cy.contains('Home').click();
    cy.url().should('include', '/');
  });

  it('should navigate to the results page when Results is clicked', () => {
    cy.visit('/');
    cy.contains('Pages').click();
    cy.wait(1000);
    cy.contains('Vote Results').click();
    cy.url().should('include', '/results');
  });

  it('should navigate to the create poll page when Create Poll is clicked', () => {
    cy.visit('/');
    cy.wait(500);
    cy.contains('Create Poll').click();
    cy.url().should('include', '/create');
    cy.contains('Create Your Custom Vote').should('be.visible'); 
  });

  it('should open Vue.js link in a new tab', () => {
    cy.visit('/');
    cy.wait(500);
    cy.contains('Useful Links').click();
    cy.wait(500);
    cy.contains('Vue.js').should('have.attr', 'href', 'https://vuejs.org/');
  });

  it('should navigate to result page when vote provided', () => {
    cy.visit('/');
    cy.wait(500);

    // -----*------
    // Needs to be dynamic - only for task purpose
    cy.contains('Are you a morning person?').click();
    cy.wait(500);
    cy.contains('Yes').click();
    cy.wait(500);
    cy.get('.p-card-footer').click();
    cy.url().should('include', '/results');
    // -----*------
  });

})
