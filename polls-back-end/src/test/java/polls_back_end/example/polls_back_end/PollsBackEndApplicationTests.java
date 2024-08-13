package polls_back_end.example.polls_back_end;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import polls_back_end.example.polls_back_end.Service.VoteService;

@SpringBootTest
class PollsBackEndApplicationTests {

   @Autowired
    private ApplicationContext applicationContext;

	@Test
	void contextLoads() {}

	@Test
    void testVoteServiceBeanLoaded() {
        VoteService voteService = applicationContext.getBean(VoteService.class);
        assertNotNull(voteService, "VoteService bean should be loaded in the context");
    }

}
