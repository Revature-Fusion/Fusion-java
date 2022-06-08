package CRUDUnitTests;

import repositories.OrderDetailsRepo;
import repositories.OrderDetailsRepoImpl;
import repositories.OrdersRepo;
import repositories.OrdersRepoImpl;
import services.OrderDetailsService;
import services.OrderDetailsServiceImpl;
import services.OrdersService;
import services.OrdersServiceImpl;

public class OrderDetailsTests {

    OrdersRepo or = new OrdersRepoImpl();
    OrdersService os = new OrdersServiceImpl(or);
    OrderDetailsRepo odr = new OrderDetailsRepoImpl();
    OrderDetailsService ods = new OrderDetailsServiceImpl(odr);

    


}
