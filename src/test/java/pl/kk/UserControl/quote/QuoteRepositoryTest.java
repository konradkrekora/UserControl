package pl.kk.UserControl.quote;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(value = false)
class QuoteRepositoryTest {

    @Autowired
    private QuoteRepository quoteRepository;

    @Autowired
    TestEntityManager entityManager;

    @Test
    @DisplayName("Should return same quote as given when user creation was successfull")
    public void testCreateQuote() {
        //given
        Quote quote = new Quote();
        quote.setContent("Każdy głupiec może napisać kod zrozumiały dla komputera. " +
                "Dobrzy programiści potrafią stworzyć kod zrozumiały dla ludzi.");
        quote.setFirstName("Martin");
        quote.setLastName("Fowler");
        //when
        Quote savedQuote = quoteRepository.save(quote);
        Quote existQuote = entityManager.find(Quote.class, savedQuote.getId());
        //then
        assertEquals(savedQuote.getContent(), existQuote.getContent());
    }

}