//package Test.rest;
//
//import com.bae.Application;
//import com.bae.persistence.domain.Details;
//import com.bae.persistence.domain.Poi;
//import com.bae.persistence.repo.DetailsRepo;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.fasterxml.jackson.databind.SerializationFeature;
//import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.format.annotation.DateTimeFormat;
//import org.springframework.http.HttpMethod;
//import org.springframework.http.MediaType;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.test.web.servlet.MockMvc;
//
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.List;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.request;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest(classes = Application.class)
//@AutoConfigureMockMvc
//public class DetailsControllerIntegrationTest<poi> {
//
//    @Autowired
//    private MockMvc mock;
//
//    @Autowired
//    private DetailsRepo detailsRepo;
//
//    private ObjectMapper mapper = new ObjectMapper();
//
//    private Details details;
//    private Details detailsId;
//    private long id;
//    private List<Poi> poi22;
//    private List<Poi> poi;
////    private Details List<Poi> poi;
//
//    @DateTimeFormat(pattern="yyyy-MM-dd")
//    private Date testDateTo = new Date();
//
//    @DateTimeFormat(pattern="yyyy-MM-dd")
//    private Date testDateFrom = new Date();
//
//    @Before
//    public void init() {
//        this.detailsRepo.deleteAll();
//        this.details = new Details("Glasgow","Manchester", testDateFrom, testDateTo);
//        this.detailsId = this.detailsRepo.save(this.details);
//        this.id = this.detailsId.getId();
//        this.poi = poi22;
////    details.setPoi(poi);
//        this.mapper.registerModule(new JavaTimeModule());
//        this.mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
//    }
//
//    @Test
//    public void getAllDetailsTest() throws Exception {
//        List<Details> detailsList = new ArrayList<>();
//        detailsList.add(this.detailsId);
//
//        String content = this.mock.perform(request(HttpMethod.GET, "/details/getAll").accept(MediaType.APPLICATION_JSON))
//                .andExpect(status().isOk()).andReturn().getResponse().getContentAsString();
//
//        assertEquals(this.mapper.writeValueAsString(detailsList), content);
//    }
//
//    @Test
//    public void getDetailTest() throws Exception {
//        List<Details> detailsList = new ArrayList<>();
//        detailsList.add(this.detailsId);
//
//        String content = this.mock.perform(request(HttpMethod.GET, "/details/get/" + this.id).accept(MediaType.APPLICATION_JSON))
//                .andExpect(status().isOk()).andReturn().getResponse().getContentAsString();
//        assertEquals(this.mapper.writeValueAsString(this.detailsId), content);
//    }
//
//    @Test
//    public void addDetailTest() throws Exception {
//        String result = this.mock
//                .perform(request(HttpMethod.POST, "/details/add").contentType(MediaType.APPLICATION_JSON)
//                        .content(this.mapper.writeValueAsString(details)).accept(MediaType.APPLICATION_JSON))
//                .andExpect(status().isOk()).andReturn().getResponse().getContentAsString();
//        assertEquals(this.mapper.writeValueAsString(detailsId), result);
//    }
//
//    @Test
//    public void updateDetailTest() throws Exception {
//        Details newDetails = new Details("Dublin","Canada", new Date(), new Date());
//        Details updatedDetails= new Details(newDetails.getOrigin(), newDetails.getDestination(), newDetails.getDateFrom(), newDetails.getDateTo());
//        updatedDetails.setId(this.id);
//
//        String result = this.mock
//                .perform(request(HttpMethod.PUT, "/details/update/" + this.id).accept(MediaType.APPLICATION_JSON)
//                        .contentType(MediaType.APPLICATION_JSON).content(this.mapper.writeValueAsString(newDetails)))
//                .andExpect(status().isOk()).andReturn().getResponse().getContentAsString();
//
//        assertEquals(this.mapper.writeValueAsString(updatedDetails), result);
//    }
//
//    @Test
//    public void deleteDetailTest() throws Exception {
//        this.mock.perform(request(HttpMethod.DELETE, "/details/delete/" + this.id)).andExpect(status().isOk());
//
//    }
//}
//
//
