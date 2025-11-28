package org.blackpowerc.training.testcontainers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.transaction.annotation.Transactional;

@DataJpaTest
@Transactional
public class BookRepositoryTest extends TestContainerConfiguration
{
    @Autowired
    private BookRepository repository ;

    @Test
    @Order(1)
    @Tag("Integration-test")
    public void save()
    {
        Assertions.assertDoesNotThrow(() ->
        {
            var book = repository.save(
                    Book.builder()
                            .title("Le personal MBA")
                            .author("Josh Kaufman")
                            .isbn("2848997567, 9782848997568")
                            .price(39.99)
                            .excerpt("""
                                    La bible du business pour faire décoller votre carrière sans passer par la case MBA !
                                                                        
                                    « Ne rangez ce livre sous aucun prétexte. Josh vous emmène dans un voyage des plus utiles à travers tous les concepts-clés du monde des affaires. » - Seth Godin, auteur de La vache pourpre et autres succès
                                                                        
                                    « Peu importe ce qu’on vous dira, un MBA n’est pas indispensable. Si vous lisez ce livre et mettez en pratique de nouvelles idées, vous ferez un immense pas en avant. » - Kevin Kelly, ancien rédacteur en chef du magazine Wired
                                                                        
                                    Obtenir un MBA est cher et pas toujours rentable. C’est ce constat qui a poussé Josh Kaufman à créer le site web PersonalMBA.com (devenu rapidement une référence) comme une alternative possible aux formations proposées dans les écoles de commerce. Sur son site, il a partagé sa liste de lecture des meilleurs livres de business à dévorer et il a expliqué de manière simple les concepts et les principes à connaître pour réussir sa carrière ou son entreprise.
                                                                        
                                    Plus qu’un site web, le Personal MBA est désormais un livre qui réunit, en un seul et même volume, toutes les connaissances indispensables du business (gestion, finance, marketing, vente, management...). Que vous soyez entrepreneur ou salarié, avec ce livre, vous avez toutes les cartes en main pour réussir.
                                    """)
                            .build()
            ) ;

            Assertions.assertNotNull(book.getId()) ;
        }) ;
    }
}