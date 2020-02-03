// package Test;

// import com.bae.persistence.domain.Details;
// import com.bae.persistence.domain.Poi;
// import org.junit.Assert;
// import org.junit.Test;

// import javax.validation.constraints.AssertTrue;
// import java.util.Date;

// public class hashcodeTests {

//     @Test
//     public void testPoiHashcode() {
//         Poi x = new Poi("Name", "Link");
//         Poi y = new Poi("Name", "Link");

//         Assert.assertTrue(x.equals(y) && y.equals(x));
//         Assert.assertTrue(x.hashCode() == y.hashCode());
//     }

//     @Test
//     public void testDetailsHashcode(){
//         Details a = new Details("Manchester", "Glasgow", new Date(), new Date());
//         Details b = new Details("Manchester", "Glasgow", new Date(), new Date());

//         Assert.assertTrue(a.equals(b) && b.equals(a));
//         Assert.assertTrue(a.hashCode() == b.hashCode());
//     }
// }
