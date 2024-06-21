import java.util.ArrayList;
// import java.util.Collections;
import java.util.Random;
// import java.util.Set;
import java.util.Scanner;

class product{
    private String product_name;
    private String product_id;
    // private float product_capacity;
    // private float product_consume ;
    private String product_description;
    private double product_price=0;
    private double product_price_elite=0;
    private double product_price_prime=0;
    private int product_quantity=0;
    private int percent1=0;
    private int percent2=0;
    private int percent3=0;
    product(String nam, String id, String desrp, float price, int quantity){
        // this.product_capacity =cap;
        // this.product_consume = consm;
        this.product_description = desrp;
        this.product_id = id;
        this.product_name = nam;
        this.product_price =  price;
        this.product_price_elite = price;
        this.product_price_prime = price;
        this.product_quantity = quantity;


    }
    product(String nam, String id, String desrp, float price1, float price2, float price3, int quantity){
        // this.product_capacity =cap;
        // this.product_consume = consm;
        this.product_description = desrp;
        this.product_id = id;
        this.product_name = nam;
        this.product_price =  price3;
        this.product_price_elite = price1;
        this.product_price_prime = price2;
        this.product_quantity = quantity;


    }
    public int getPercent1() {
        return percent1;
    }
    public int getPercent2() {
        return percent2;
    }
    public int getPercent3() {
        return percent3;
    }
    public void setPercent1(int percent1) {
        this.percent1 = percent1;
    }
    public void setPercent2(int percent2) {
        this.percent2 = percent2;
    }
    public void setPercent3(int percent3) {
        this.percent3 = percent3;
    }
    public int getProduct_quantity() {
        return product_quantity;
    }
    public void setProduct_quantity(int product_quantity) {
        this.product_quantity = product_quantity;
    }

    public String getProduct_description() {
        return product_description;
    }
    public void setProduct_description(String product_description) {
        this.product_description = product_description;
    }
    public String getProduct_id() {
        return product_id;
    }
    public String getProduct_name() {
        return product_name;
    }
    public double getProduct_price() {
        return product_price;
    }
    public double getProduct_price_elite() {
        return product_price_elite;
    }
    public double getProduct_price_prime() {
        return product_price_prime;
    }

    public void setProduct_price_elite(double d) {
        this.product_price_elite = d;
    }
    public void setProduct_price_prime(double d) {
        this.product_price_prime = d;
    }

    public void setProduct_id(String product_id) {
        this.product_id = product_id;
    }
    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }
    public void setProduct_price(double d) {
        this.product_price = d;
    }
    
    

}

class category{
    private String category_name;
    private int category_id;
    private ArrayList <product> product_ArrayList = new ArrayList<product>(100);
    category(String nam, int id){
        this.category_id =id;
        this.category_name = nam;
    }
    public int getCategory_id() {
        return category_id;
    }
    public String getCategory_name() {
        return category_name;
    }
    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }
    public void setCategory_name(String category_name) {
        this.category_name = category_name;
    }
    public void remove_from_Product_ArrayList(String id) {
        int i =0;
        for (product product1 : this.product_ArrayList) {
            if(product1.getProduct_id().equals(id)){
                this.product_ArrayList.remove(i);
                break;

            }
            i++;
        }

    }

    public ArrayList<product> getProduct_ArrayList() {
        return product_ArrayList;
    }
    public void setProduct_ArrayList(product new_pro) {
        this.product_ArrayList.add(new_pro);

    }

}

interface adm_helper{
    boolean enter_as_admin(String Adm_name, String pass);
    product details_of_product(String id);
    void Set_Discount_on_product(String id, int percent1, int percent2, int percent3);
    void Add_giveaway_deals(String id1, String id2, float price1, float price2, float price3, int quantity);

}

class admin implements adm_helper{
    private String admin_name;
    private String admin_password;
    private ArrayList <category> category_list= new ArrayList <category>(100);
    private int deal_flag =0;
    
    admin(String Adm_name, String pass) {
        this.admin_name = Adm_name;
        this.admin_password =pass;

    }

    public String getAdmin_name() {
        return admin_name;
    }
    public String getAdmin_password() {
        return admin_password;
    }

    public ArrayList<category> getCategory_list() {
        return category_list;
    }
    
    

    public boolean enter_as_admin(String Adm_name, String pass){
        if(this.admin_name.equals(Adm_name) && admin_password.equals(pass)){
            return true;
        }
  
        return false;
        

    }

    public void Add_Category(int category_id, String category_name, String nam, String id, String desp, float price, int quantity){
        for (category categorychk : category_list) {
            if(categorychk.getCategory_id() == category_id){
                System.out.println("Category already exists, try new category ID");
                return;
            }

            
        }
        product new_Product = new product(nam, id, desp, price, quantity);
        category new_category = new category(category_name, category_id);
        new_category.setProduct_ArrayList(new_Product);
        this.category_list.add(new_category);
    }
    public void Add_Category(int category_id, String category_name, String nam, String id, String desp, float price1,float price2,float price3, int quantity){
        product new_Product = new product(nam, id, desp, price1, price2, price3, quantity);
        category new_category = new category(category_name, category_id);
        new_category.setProduct_ArrayList(new_Product);
        this.category_list.add(new_category);
    }

    public void Delete_Category(int category_id, String category_name){
        int i =0;
        for (category category1 : category_list) {

            if(category1.getCategory_id() == category_id && category1.getCategory_name().equals(category_name)){
                this.category_list.remove(i);
                break;
            }
            i++;
            
        }
    

    }

    public void Add_Product(int category_id,String nam, String id, String desp, float price, int quantity){
        
        product new_Product = new product(nam, id, desp, price, quantity);
        for (category category1 : category_list) {
            for (product pro : category1.getProduct_ArrayList()) {
                if(pro.getProduct_id().equals(id)){
                    System.out.println("Already exists a product on this ID, try new ID");
                    return;
                }
                
            }
            if(category1.getCategory_id() == category_id){
                category1.setProduct_ArrayList(new_Product);
                break;
            }
            
        }
    }
    public void Add_Product(int category_id,String nam, String id, String desp, float price1, float price2, float price3, int quantity){
        
        product new_Product = new product(nam, id, desp, price1, price2, price3,quantity);
        for (category category1 : category_list) {
            if(category1.getCategory_id() == category_id){
                category1.setProduct_ArrayList(new_Product);
                break;
            }
            
        }
    }

    public void Delete_Product(String category_name, String id){

        
        for (category category1 : category_list) {
            if(category1.getCategory_name().equals(category_name)){
                // category1.setProduct_ArrayList(new_Product);

                if(category1.getProduct_ArrayList().size()!=1){
                    category1.remove_from_Product_ArrayList(id);
                
                    break;
                }
                else{
                    Delete_Category(category1.getCategory_id(), category_name);
                    break;
                }
                
            }
        }
    }
    public product details_of_product(String id){

        product pro=null;
        for (category category1 : category_list) {
            for (product prod : category1.getProduct_ArrayList()) {
                if(id.equals(prod.getProduct_id())){
                    pro= prod;
                    return pro;
                    

                }
                
            }
            
        }
        return pro;

    }

    public void Set_Discount_on_product(String id, int percent1, int percent2, int percent3){
        for (category category1 : category_list) {
            for (product product1 : category1.getProduct_ArrayList()) {
                if(product1.getProduct_id().equals(id)){
                    product1.setPercent1(percent1);
                    product1.setPercent2(percent2);
                    product1.setPercent3(percent3);
                    // product1.setProduct_price(product1.getProduct_price()*(1-(percent3)/100));
                    // product1.setProduct_price_prime((product1.getProduct_price_prime()*(1-(percent2)/100))*(0.95));
                    // product1.setProduct_price_elite(product1.getProduct_price_elite()*(1-(percent1)/100)*0.9);
                    break;


                }
                
            }

            
        }        


    }
    public void Add_giveaway_deals(String id1, String id2, float price1, float price2, float price3, int quantity){
        // if()
        int i1=0;
        int i2=0;
        int j=0;
        int k =0;
        int l =0;
        int m=0;
        for (category category1 : category_list) {
            i2=0;
            for (product product1 : category1.getProduct_ArrayList()) {

                if(product1.getProduct_id().equals(id1)){
                    j= i1;

                    k=i2;
                }
                if(product1.getProduct_id().equals(id2)){
                    l=i1;
                    m =i2;
                }
                i2++;   
            }
            i1++;
        }
        product pro1 = category_list.get(j).getProduct_ArrayList().get(k);
        product pro2 = category_list.get(l).getProduct_ArrayList().get(m);
        double pr1=  pro1.getProduct_price()*(100-pro1.getPercent1())/100 + pro2.getProduct_price()*(100-pro2.getPercent1())/100;
        System.out.println(pr1);
        double pr2=  pro1.getProduct_price()*(100-pro1.getPercent2())/100 + pro2.getProduct_price()*(100-pro2.getPercent2())/100;
        System.out.println(pr2);

        double pr3=  pro1.getProduct_price()*(100-pro1.getPercent3())/100+ pro2.getProduct_price()*(100-pro2.getPercent3())/100;
        System.out.println(pr3);
        if(price1>=pr1){
            System.out.println("set less price for elite");
            return;
        }
        if(price2>=pr2){
            System.out.println("set less price for prime");
            return;
        }
        if(price3>=pr3){
            System.out.println("set less price for normal");
            return;
        }
            String nam1 = category_list.get(j).getProduct_ArrayList().get(k).getProduct_name();
            String nam2 = category_list.get(l).getProduct_ArrayList().get(m).getProduct_name();
            String id4 = category_list.get(l).getProduct_ArrayList().get(m).getProduct_id();
            String id3 = category_list.get(j).getProduct_ArrayList().get(k).getProduct_id();
            String desp1 = category_list.get(j).getProduct_ArrayList().get(k).getProduct_description();
            String desp2 = category_list.get(l).getProduct_ArrayList().get(m).getProduct_description();


            if(deal_flag==0){
                
                Add_Category(10, "DEALS", nam1 +" & " +nam2, id3+"_"+id4, "First Product: "+desp1 + "\nSecond Product: "+desp2, price1, price2, price3, quantity);
                deal_flag =1;
            }
            else{
                Add_Product(10, nam1 +" & " +nam2, id3+"_"+id4,desp1 + "\nSecond Product: "+desp2, price1, price2, price3, quantity);
            }

        

    }
}

interface customer_helper{
    boolean Log_in(String name, String email, String passw, ArrayList <customer> arr);
    void Browse_products(admin adm);
    void Browse_deals(admin adm);
    void view_CART();
    void add_product_to_cart(String id, int quantity, admin adm);
    void add_deal_in_cart(String id, int quantity, admin adm);
    void Upgrade_Status(String s);
    void empty_cart();
    void view_coupons();
    void add_Money(float amt);
    void check_acc_balance();
    void checkout_cart();

}

class customer {
    private String cust_name;
    private int cust_age;
    private String cust_email;
    private String cust_password;
    private int status=0;
    private float money=1000;
    private ArrayList <product> cart = new ArrayList<product>(100);
    private float totalPriceCart=0;
    private float totalPriceCart_without_disc=0;
    private ArrayList <Integer> coupon_list = new ArrayList<Integer>(100);




    
    customer(String name, int age, String email, String pass){
        this.cust_age = age;
        this.cust_email = email;
        this.cust_password = pass;
        this.cust_name = name;
    }

    public float getTotalPriceCart() {
        return totalPriceCart;
    }
    public void setTotalPriceCart(float totalPriceCart) {
        this.totalPriceCart = totalPriceCart;
    }
    public int getCust_age() {
        return cust_age;
    }
    public String getCust_email() {
        return cust_email;
    }
    public String getCust_name() {
        return cust_name;
    }
    public String getCust_password() {
        return cust_password;
    }
    public float getMoney() {
        return money;
    }
    public int getStatus() {
        return status;
    }
    public void setCust_age(int cust_age) {
        this.cust_age = cust_age;
    }
    public void setCust_email(String cust_email) {
        this.cust_email = cust_email;
    }
    public void setCust_name(String cust_name) {
        this.cust_name = cust_name;
    }
    public void setCust_password(String cust_password) {
        this.cust_password = cust_password;
    }
    public void setMoney(float money) {
        this.money = money;
    }
    public void setStatus(int status) {
        this.status = status;
    }



    public boolean Log_in(String name, String email, String passw, ArrayList <customer> arr){

        for (customer customer1 : arr) {
            if(customer1.cust_name.equals(name) && customer1.cust_email.equals(email) && customer1.getCust_password().equals(passw)){
                return true;

            }            
        }
        return false;
    }
    public void Browse_products(admin adm){
        for (category category1 : adm.getCategory_list()) {
            if(category1.getCategory_id() == 10){
                continue;
            }
            
            for (product prod : category1.getProduct_ArrayList()) {
                System.out.println(prod.getProduct_name());
                System.out.println(prod.getProduct_id());
                System.out.println(prod.getProduct_description());
                
                if(this.status==0){
                    System.out.println(prod.getProduct_price());

                }
                else if(this.status==1){
                    System.out.println(prod.getProduct_price_prime());

                }  
                else if(this.status==2){
                    System.out.println(prod.getProduct_price_elite());

                }
            }
            
        }


    }
    

    public void Browse_deals(admin adm){

        for (category category1 : adm.getCategory_list()) {
            if(category1.getCategory_id() == 10){
                
            
            for (product prod : category1.getProduct_ArrayList()) {
                System.out.println(prod.getProduct_name());
                System.out.println(prod.getProduct_id());
                System.out.println(prod.getProduct_description());
                
                if(this.status==0){
                    System.out.println(prod.getProduct_price());

                }
                else if(this.status==1){
                    System.out.println(prod.getProduct_price_prime());

                }  
                else if(this.status==2){
                    System.out.println(prod.getProduct_price_elite());

                }
            }
            break;
        }

            
        }


    }

    public int getmaxcoupon(){
        int max =0;
        int i =0;
        int store=0;


        for (int numb: coupon_list) {
            // System.out.println("Coupons "+i+": "+numb+"%");
            if(numb>max){
                store = i;
                max = numb;

            }
            i++;    
        }

        

        return store;
    }
    private int coupon_flag =0;
    public int maximumfunc(int a, int b, int c){
        if(a>=b && a>=c){
            System.out.println("Applying discount of "+a+"%");
            return a;
        }

        if(b>=a && b>=c){
            System.out.println("Applying membership discount of "+b+"%");
            return b;
        }        
        if(c>=b && c>=a){
            coupon_flag =1;
            System.out.println("Applying coupon of "+c+"%");
            return c;
        }
        return 0;

    }
    public void view_CART(){
        float price_without_discount=0;
        float price_with_discount=0;
        
        for (product product1 : cart) {
            if(!product1.getProduct_id().contains("_")){
                System.out.println("Name of product: "+product1.getProduct_name());
                System.out.println("product id: "+  product1.getProduct_id());
                price_without_discount += product1.getProduct_price();
                if(this.status==0){
                    // product1.getPercent1()
                    price_with_discount += product1.getProduct_price()*(1-(product1.getPercent3()/100));
                    System.out.println("product price: "+  product1.getProduct_price()*(1-(product1.getPercent3()/100)));



                }
                else if(this.status==1){
                    if(coupon_list.isEmpty()){
                        price_with_discount += product1.getProduct_price()*(100-maximumfunc(product1.getPercent2(), 5, 0))/100;
                        System.out.println("product price: "+   product1.getProduct_price()*(100-maximumfunc(product1.getPercent2(), 5, 0))/100 +"(just to confirm)");
                    

                    }
                    else{
                        price_with_discount += product1.getProduct_price()*(100-maximumfunc(product1.getPercent2(), 5, coupon_list.get(getmaxcoupon())))/100;
                        System.out.println("product price: "+   product1.getProduct_price()*(100-maximumfunc(product1.getPercent2(), 5, coupon_list.get(getmaxcoupon())))/100+"(just to confirm)");
                    }

                }  
                else if(this.status==2){
                    if(coupon_list.isEmpty()){
                        price_with_discount += product1.getProduct_price()*(100-maximumfunc(product1.getPercent1(), 10, 0))/100;
                        System.out.println("product price: "+ product1.getProduct_price()*(100-maximumfunc(product1.getPercent1(), 10, 0))/100+"(just to confirm)");

                    }
                    else{
                    price_with_discount += product1.getProduct_price()*(100-maximumfunc(product1.getPercent1(), 10, coupon_list.get(getmaxcoupon())))/100;
                    System.out.println("product price: "+ product1.getProduct_price()*(100-maximumfunc(product1.getPercent1(), 10, coupon_list.get(getmaxcoupon())))/100+"(just to confirm)");
                    }


                }
                System.out.println(product1.getProduct_description());
                System.out.println();

            }
            else{
                System.out.println("Name of product: "+product1.getProduct_name());
                System.out.println("product id: "+  product1.getProduct_id());
                price_without_discount += product1.getProduct_price();
                if(this.status==0){
                    // product1.getPercent1()
                    price_with_discount += product1.getProduct_price();
                    System.out.println("product price: "+  product1.getProduct_price());



                }
                else if(this.status==1){
                        price_with_discount += product1.getProduct_price_prime();
                        System.out.println("product price: "+   product1.getProduct_price_prime());
                    
                }  
                else if(this.status==2){
                    price_with_discount += product1.getProduct_price_elite();

                    System.out.println("product price: "+   product1.getProduct_price_elite());

                }
                System.out.println(product1.getProduct_description());
                System.out.println();

            }

        }
        System.out.println("Total price excluding delivery charges: "+ price_with_discount);
        totalPriceCart = price_with_discount;
        totalPriceCart_without_disc = price_without_discount;
    }


    public void add_product_to_cart(String id, int quantity, admin adm){

        product p = adm.details_of_product(id);
        if(p==null){
            System.out.println("No such product exist");
            return;
        }


        if(p.getProduct_quantity()<quantity){
            System.out.println("please lower the quantity demanded, we have only "+p.getProduct_quantity()+" products left");
            return;
        }
        if(p.getProduct_quantity()<=0){
            System.out.println("No product left, can't add product in cart");
            return;
        }
        for (int i = 0; i < quantity; i++) {
            // if(p.getProduct_quantity()<=0 || p.getProduct_quantity()<quantity){
            //     System.out.println("Not much product left, only "+(i+1)+" products are added");
            //     return;

            // }
             cart.add(p);
        }
       

        System.out.println("Successfully added the products to cart, left products are "+ p.getProduct_quantity());
    }

    public void add_deal_in_cart(String id, int quantity, admin adm){
        // category c = adm.getCategory_list().get(10);
        category c = null;
        for (category cat : adm.getCategory_list()) {
            if(cat.getCategory_id() == 10){
                c = cat;
                break;

            }
            
        }
        product p = null;
        for (product product1 : c.getProduct_ArrayList()) {
            if(product1.getProduct_id().equals(id)){
                p = product1;
                break;

            }
        }
        if(p==null){
            System.out.println("No such product exist");
        }
        if(p.getProduct_quantity()<quantity){
            System.out.println("please lower the quantity demanded, we have only "+p.getProduct_quantity()+" products left");
            return;
        }
        if(p.getProduct_quantity()<=0){
            System.out.println("No product left, can't add product in cart");
            return;
        }

        for (int i = 0; i < quantity; i++) {
            // if(p.getProduct_quantity()<=0){
            //     System.out.println("No much product left");
            //     return;

            // }
             cart.add(p);
        }
        System.out.println("Successfully added the product to cart");
    }

    

    public void Upgrade_Status(String s){

        if(s.equals("ELITE")){
            if(this.status==1){
                this.status=2;
                this.money = this.money -100;
                System.out.println("Status updated to: ELITE");
                return;

            }
            this.status =2;
            this.money = this.money -300;
            System.out.println("Status updated to: ELITE");


        }
        else if(s.equals("PRIME")){
            if(status==1){
                System.out.println("Status already prime");
                return;


            }
            else if(status ==2){
                // System.out.println();
                this.status =1;
                System.out.println("Status updated to: PRIME");

                return;

            }
            this.status =1;
            this.money = this.money -200;
            System.out.println("Status updated to: PRIME");


        }

    }

    public void empty_cart(){
        // ArrayList <product> cartCopy = cart.clone();
        // ArrayList <product> cartCopy = (ArrayList<product>)cart.clone();
        // cartCopy = cart.clone();
        int s = cart.size();
        for (int i =0; i<s;i++) {
            // cart.get(0).setProduct_quantity(cart.get(0).getProduct_quantity()+1);

            cart.remove(0);
            // cart.r
            
            
        }
        setTotalPriceCart(0);

    }
    public void empty_cart1(){
        // ArrayList <product> cartCopy = cart.clone();
        // ArrayList <product> cartCopy = (ArrayList<product>)cart.clone();
        // cartCopy = cart.clone();
        int s = cart.size();
        for (int i =0; i<s;i++) {
            cart.get(0).setProduct_quantity(cart.get(0).getProduct_quantity()+1);

            cart.remove(0);
            // cart.r
            
            
        }
        setTotalPriceCart(0);

    }
    public void view_coupons(){
        int i=1;

        for (int numb: coupon_list) {
            System.out.println("Coupons "+i+": "+numb+"%");
            i++;


            
        }

    }

    public void generate_coupons(){
        Random random = new Random();

        if(this.totalPriceCart>5000){
            if(this.status==2){

            for (int i = 0; i < 4; i++) {
                int x = random.nextInt(5, 15);
                this.coupon_list.add(x);
                System.out.println("You get coupon of "+x+"%");

                
            }
            boolean b = random.nextBoolean();
            if(b){
                System.out.println("Congrats you will be getting surprise gift");
            }
        }
        else if(this.status==1){

            for (int i = 0; i < 2; i++) {
                int x = random.nextInt(5, 15);
                this.coupon_list.add(x);
                System.out.println("You get coupon of "+x+"%");


                
            }
        }

            
        }
        
    }

    public void add_Money(float amt){
        this.money+=amt;
        System.out.println("Amount successfully added");

    }

    public void check_acc_balance(){
        System.out.println("Account balance: "+this.money);
    }

    public void checkout_cart(){
            if(this.status==0){
                double delivery_charges= 100+ (totalPriceCart * 0.05); 
                if(this.money>=totalPriceCart){




                    for (product product1 : cart) {
                        if(product1.getProduct_quantity()<=0){
                            System.out.println("We can't proceed payment because someone already bought your cart product before you checkouted");
                            // empty_cart1();
                            return;
                        }
                        product1.setProduct_quantity(product1.getProduct_quantity()-1);

                        
                    }
                    view_CART();
                    this.totalPriceCart += delivery_charges;
                    this.money = this.money- totalPriceCart;
                    System.out.println("DELIVERY CHARGES: "+ delivery_charges);
                    System.out.println("TOTAL CHARGES: "+totalPriceCart);
                    System.out.println("Items will be delivered in 7-10 days");

                }
                else{
                    System.out.println("Not enough money");
                    return;

                }

            }
            
            else if(status ==1){
                double delivery_charges= 100+totalPriceCart_without_disc * 0.02; 
                if(this.money>=totalPriceCart){
                    for (product product1 : cart) {
                        if(product1.getProduct_quantity()<=0){
                            System.out.println("We can't proceed payment because someone already bought your cart product before you checkouted");
                            // empty_cart1();
                            return;
                        }
                        product1.setProduct_quantity(product1.getProduct_quantity()-1);
                        
                    }

                    if(coupon_flag==1){
                        coupon_list.remove(getmaxcoupon());
                    }
                    view_CART();
                    this.totalPriceCart +=delivery_charges;

                    this.money = this.money- totalPriceCart;

                    System.out.println("DELIVERY CHARGES: "+delivery_charges);
                    System.out.println("TOTAL CHARGES: "+totalPriceCart);
                    System.out.println("Items will be delivered in 3-6 days");
                    generate_coupons();
                }
                else{
                    System.out.println("Not enough money");
                    return;

                }

            }
            else if(this.status==2){
                double delivery_charges =100;

                if(this.money>=totalPriceCart){
                    for (product product1 : cart) {

                        if(product1.getProduct_quantity()<=0){
                            System.out.println("We can't proceed payment because someone already bought your cart product before you checkouted");
                            // empty_cart1();
                            return;
                        }
                        product1.setProduct_quantity(product1.getProduct_quantity()-1);
                        // System.out.println(product1.getProduct_quantity());
                        
                    }

                    if(coupon_flag==1){
                        coupon_list.remove(getmaxcoupon());
                    }
                    view_CART();
                    this.totalPriceCart +=delivery_charges;

                    this.money = this.money- totalPriceCart;

                    System.out.println("DELIVERY CHARGES: "+delivery_charges);
                    System.out.println("TOTAL CHARGES: "+totalPriceCart);
                    System.out.println("Items will be delivered in 2 days");

                    generate_coupons();


                }
                else{
                    System.out.println("Not enough money");
                    return;

                }
                
            }

        // empty_cart();
        // ArrayList cartCopy = new ArrayList<>();
        // cartCopy = (Arraylist)cart.clone();
        int s = cart.size();
        for (int i = 0; i < s; i++) {
            cart.remove(0);
            
        }

        this.coupon_flag=0;
    }


}



public class code_1 {
    public static void main(String[] args) {

        admin adm =new admin("jeff", "jeff1");
        customer c1 = new customer("Visitor", 0, null, null);
        ArrayList <customer> cArrayList = new ArrayList<customer>(100);
        
        System.out.println("WELCOME TO FLIPZON");

        Scanner sc = new Scanner(System.in);

        while(true){
            System.out.println("1) Enter as Admin\n2) Explore the Product Catalog\n3) Show Available Deals\n4) Enter as Customer\n5) Exit the Application\n");
            int sc_int = sc.nextInt();

            // System.out.println("");
            if(sc_int ==1){
                System.out.println("Please Enter username and password");
                String sc_str1 = sc.next();
                String sc_str2 = sc.next();
                if(adm.enter_as_admin(sc_str1, sc_str2)){
                    while(true){
                        System.out.println("Welcome "+ adm.getAdmin_name());
                        System.out.println("Please choose any one of the following actions:\n1) Add category\n2) Delete category\n3) Add Product\n4) Delete Product\n5) Set Discount on Product\n6) Add giveaway deal\n7) Back\n");
                        sc_int = sc.nextInt();
                        if(sc_int==1){
                            System.out.println("Add category ID: ");
                            int sc_int1 = sc.nextInt();
                            System.out.println("Add name of the category: ");
                            sc_str1 = sc.next();
                            System.out.println("Enter Product Name, Product ID, Product Descryption, price, quantity\n");
                            sc_str2 = sc.next();
                            String sc_str3 = sc.next();
                            String sc_str4 = sc.next();
                            int sc_int2 = sc.nextInt();
                            int sc_int3 = sc.nextInt();



                            adm.Add_Category(sc_int1, sc_str1, sc_str2, sc_str3, sc_str4, sc_int2, sc_int3);
                        }
                        else if(sc_int ==2){
                            System.out.println("Enter Category ID, Category name\n");
                            int sc_int1 = sc.nextInt();
                            sc_str2 = sc.next();



                            adm.Delete_Category(sc_int1, sc_str2);
                        }
                        else if(sc_int==3){
                            System.out.println("Enter Category ID,Product Name, Product ID, Product Descryption, price, quantity\n");
                            int sc_int1 = sc.nextInt();
                            sc_str2 = sc.next();
                            String sc_str3 = sc.next();
                            String sc_str4 = sc.next();
                            int sc_int2 = sc.nextInt();
                            int sc_int3 = sc.nextInt();

                            adm.Add_Product(sc_int1, sc_str2, sc_str3, sc_str4, sc_int2, sc_int3);

                        }
                        else if(sc_int ==4){
                            System.out.println("Enter Category Name,Product ID\n");
                            sc_str1 = sc.next();
                            sc_str2 = sc.next();


                            adm.Delete_Product(sc_str1, sc_str2);

                        }
                        else if(sc_int==5){
                            System.out.println("Enter Product ID, discount percent for elite, discount percent for prime, discount percent for normal\n");
                            sc_str2 = sc.next();
                            int sc_int1 = sc.nextInt();
                            int sc_int2 = sc.nextInt();
                            int sc_int3 = sc.nextInt();
                            adm.Set_Discount_on_product(sc_str2, sc_int1, sc_int2, sc_int3);
                        }
                        else if(sc_int==6){
                            System.out.println("Enter Product 1 ID, Product 2 ID, price for elite, price for prime, price for normal, quantity\n");
                            sc_str1 = sc.next();
                            sc_str2 = sc.next();
                            int sc_int1 = sc.nextInt();
                            int sc_int2 = sc.nextInt();
                            int sc_int3 = sc.nextInt();
                            int sc_int4 = sc.nextInt();
                            

                            adm.Add_giveaway_deals(sc_str1, sc_str2, sc_int1, sc_int2, sc_int3, sc_int4);
                        }
                        else{
                            break;
                        }
                    }
                }
                else{
                    System.out.println("Wrong Admin username or password");
                    continue;
                }



            }
            else if(sc_int ==2){
                c1.Browse_products(adm);
            }
            else if(sc_int ==3){
                c1.Browse_deals(adm);
            }
            else if(sc_int ==4){
                // sc_int = sc.nextInt();
                while(true){
                    System.out.println("1) Sign up\n2) Log in\n3) Back\n");
                    sc_int = sc.nextInt();
                    if(sc_int ==1){
                        System.out.println("Enter Name, age, email,password\n");
                        String sc_str1 = sc.next();
                        int sc_int1 = sc.nextInt();
                        String sc_str2 = sc.next();
                        String sc_str3 = sc.next();

                        customer c2 = new customer(sc_str1, sc_int1, sc_str2, sc_str3);
                        cArrayList.add(c2);



                    }
                    else if(sc_int ==2){
                        System.out.println("Enter Name, Password\n");
                        String sc_str1= sc.next();
                        String sc_str2= sc.next();
                        customer c = null;
                        for (customer customer1 : cArrayList) {
                            if(customer1.getCust_name().equals(sc_str1) && customer1.getCust_password().equals(sc_str2)){
                                c = customer1;
                                break;
                                
                            }
                            
                        }
                        if(c!=null){
                            System.out.println("Welcome "+c.getCust_name());
                            while(true){
                                
                                System.out.println("1) browse products\n2) browse deals\n3) add a product to cart\n4) add products in deal to cart\n5) view coupons\n6) check account balance\n7) view cart\n8) empty cart\n9) checkout cart\n10) upgrade customer status\n11) Add amount to wallet\n12) back\n");
                                sc_int = sc.nextInt();
                                if(sc_int==1){
                                    c.Browse_products(adm);
                                }
                                else if(sc_int ==2){
                                    c.Browse_deals(adm);
                                }
                                else if(sc_int ==3){
                                    System.out.println("Enter product ID, quantity");
                                    sc_str2 = sc.next();
                                    int sc_int1 = sc.nextInt();
                                    c.add_product_to_cart(sc_str2, sc_int1, adm);

                                }
                                else if(sc_int ==4){
                                    System.out.println("Enter product ID, quantity");
                                    sc_str2 = sc.next();
                                    int sc_int1 = sc.nextInt();
                                    c.add_deal_in_cart(sc_str2, sc_int1, adm);
                                }
                                else if(sc_int ==5){

                                    c.view_coupons();

                                }
                                else if(sc_int==6){
                                    c.check_acc_balance();
                                }
                                else if(sc_int ==7){
                                    c.view_CART();
                                }
                                else if(sc_int ==8){
                                    c.empty_cart();

                                }
                                else if(sc_int ==9){
                                    c.checkout_cart();
                                }
                                else if(sc_int==10){
                                    int a = c.getStatus();
                                    if(a==0){
                                        System.out.println("current status: Normal");
                                    }
                                    else if(a==1){
                                        System.out.println("current status: Prime");


                                    }
                                    else if(a==2){
                                        System.out.println("current status: elite");

                                    }
                                    System.out.println("Enter the status you want to get upgraded: ");
                                    sc_str2 = sc.next();
                                    c.Upgrade_Status(sc_str2);
                                }
                                else if(sc_int ==11){
                                    System.out.println("Enter money to add in wallet: ");
                                    int sc_int1 = sc.nextInt();
                                    c.add_Money(sc_int1);
                                }
                                else{
                                    break;
                                }


                            }

                        }
                        else{
                            System.out.println("Wrong details");
                        }


                    }
                    else{
                        break;
                    }

                }


            }

            else{
                break;
            }


        }
        
        




    }
    
}
