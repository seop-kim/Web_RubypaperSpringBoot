package com.rubypaper;

import com.rubypaper.Chapter03.service.BoardService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @WebMvcTest 의 경우 컨트롤러만 구동하여 테스트를 하고
 * AutoConfigureMockMvc 는 @Service @Repository 까지 모두 메모리에 올려 테스트를 한다.
 * 따라서 간단하게 컨트롤러만 구동하여 테스트를 진행하고자 한다면 @WebMvcTest 를 사용해야한다.
 * @SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK) 는 AutoConfigureMockMvc 을 사용할 때
 * 설정에서 서블릿 컨테이너를 모킹하여 사용할지에 대한 여부이다 MOCK 은 모킹하여 사용하는 것이고 외에는 실제 서블릿 컨테이너를 사용하는 것이다.(?)
 * 자세한 내용은 책 137p 를 참고하도록 한다.
 */

//@WebMvcTest
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@AutoConfigureMockMvc
public class BoardControllerTest {

    @Autowired
    private MockMvc mockMvc;

//    @Autowired
//    private TestRestTemplate restTemplate;

    @MockBean
    private BoardService boardService;

    @Test
    public void testHello() throws Exception {
        /**
         * perform 은 브라우저에서 서버애 URL을 요청 하듯 컨트롤러를 실행시키는 것이다.
         * andExpect는 서버의 응답 결과를 검증할 수 있다.
         *
         * perform 은 RequestBuilder 객체를 인자로 받고 MockMvcRequestBuilders의 정적 메소드를 이용해서 생성한다.
         * get, post, put, delete 요청방식과 매칭되는 메소드를 제공한다.
         * param 메소드를 사용하여 "키=값" 파라미터를 여러개 전달할 수 있으며 MockMvcRequestBuilders 객체를 리턴해주기에 메시지 체인을 구성하여 복잡한 요청을 할 수 있다.
         * 또한 요청을 전송하면 ResultAction 객체를 리턴해주는데 응답 결과를 검증할 수 있는 andExpect 메소드를 제공해준다.
         *
         * status() 메소드는 StatusResultMatchers 객체를 리턴하는데 이 객체는 응답 상태 코드를 검증할 수 있다.
         * 컨트롤러가 뷰를 검증할때는 view() 메소드를 사용하면 되며 코드는 andExpect(view().name("hello") 와 같이 작성하면 리턴한 뷰 이름이 hello 인지 검증해준다.
         *
         * 마지막으로 요청과 응답 메시지를 확인해보고 싶다면 andDo() 메소드를 이용하면 된다.
         */
        //mockMvc.perform(get("/hello").param("name", "둘리")).andExpect(status().isOk()).andExpect(content().string("Hello : 둘리")).andDo(print());


        //BoardVO board = restTemplate.getForObject("/getBoard", BoardVO.class);
        //assertEquals("테스터", board.getWriter());

        when(boardService.hello("둘리")).thenReturn("Hello : 둘리");

        mockMvc.perform(get("/hello").param("name", "둘리")).andExpect(status().isOk()).andExpect(content().string("Hello : 둘리")).andDo(print());

    }
}
