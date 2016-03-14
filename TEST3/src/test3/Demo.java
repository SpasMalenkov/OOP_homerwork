package test3;

import java.util.Iterator;
import java.util.List;

public class Demo {

	public static void main(String[] args) throws ClientException, InterruptedException {
		
		MainOffice turnovo = new MainOffice();
		CityOffice sofia = new CityOffice(CityName.SOFIA);
		CityOffice plovdiv = new CityOffice(CityName.PLOVDIV);
		CityOffice varna = new CityOffice(CityName.VARNA);
		CityOffice ruse = new CityOffice(CityName.RUSE);
		
		Client[] poluchateli1 = {
				new Client("Vasil Vasilev", "0888789789", 9103035656l, "ulica 'devet' nomer 1", CityName.RUSE),
				new Client("Vasil Vasilev", "0888789789", 9103035656l, "ulica 'devet' nomer 1", CityName.PLOVDIV),
				new Client("Vasil Vasilev", "0888789789", 9103035656l, "ulica 'devet' nomer 1", CityName.PLOVDIV),
				new Client("Vasil Vasilev", "0888789789", 9103035656l, "ulica 'devet' nomer 1", CityName.VARNA),
				new Client("Vasil Vasilev", "0888789789", 9103035656l, "ulica 'devet' nomer 1", CityName.VARNA)
		};
	
		Client[] poluchateli2 = {
			new Client("Vasil Vasilev", "0888789789", 9103035656l, "ulica 'devet' nomer 1", CityName.SOFIA),
			new Client("Vasil Vasilev", "0888789789", 9103035656l, "ulica 'devet' nomer 1", CityName.SOFIA),
			new Client("Vasil Vasilev", "0888789789", 9103035656l, "ulica 'devet' nomer 1", CityName.SOFIA),
			new Client("Vasil Vasilev", "0888789789", 9103035656l, "ulica 'devet' nomer 1", CityName.SOFIA),
			new Client("Vasil Vasilev", "0888789789", 9103035656l, "ulica 'devet' nomer 1", CityName.PLOVDIV),
			new Client("Vasil Vasilev", "0888789789", 9103035656l, "ulica 'devet' nomer 1", CityName.PLOVDIV),
			new Client("Vasil Vasilev", "0888789789", 9103035656l, "ulica 'devet' nomer 1", CityName.RUSE),
			new Client("Vasil Vasilev", "0888789789", 9103035656l, "ulica 'devet' nomer 1", CityName.RUSE),
			new Client("Vasil Vasilev", "0888789789", 9103035656l, "ulica 'devet' nomer 1", CityName.RUSE)
		};
		
		
		for(int i = 1; i < poluchateli2.length; i++){
			
			if(i < poluchateli1.length){
				new Thread(new Staff("Ivan Ivanov", "0898789789", 9105056565l, "ulica 'purva' nomer 9", sofia, poluchateli1[i])).start();
				Thread.sleep(1000);
			}else{
				new Thread(new Staff("Ivan Ivanov", "0898789789", 9105056565l, "ulica 'purva' nomer 9", sofia)).start();
			}
			
			new Thread(new Staff("Cvetan Cvetanov", "0898789789", 9105056565l, "ulica 'purva' nomer 9", varna, poluchateli2[i])).start();
			Thread.sleep(1000);
			
			new Thread(new CourierToMainOffice("Stoyan Stoyanov", "0898789789", 9105056565l, "ulica 'purva' nomer 9", varna, turnovo)).start();
			Thread.sleep(1000);
			new Thread(new CourierToMainOffice("Stoyan Stoyanov", "0898789789", 9105056565l, "ulica 'purva' nomer 9", sofia, turnovo)).start();
			Thread.sleep(1000);
			new Thread(new CourierFromMainOffice("Ilian Iliev","0898789789", 9105056565l, "ulica 'purva' nomer 9", sofia, turnovo)).start();
			new Thread(new CourierFromMainOffice("Ilian Iliev","0898789789", 9105056565l, "ulica 'purva' nomer 9", varna, turnovo)).start();
			new Thread(new CourierFromMainOffice("Ilian Iliev","0898789789", 9105056565l, "ulica 'purva' nomer 9", plovdiv, turnovo)).start();
			new Thread(new CourierFromMainOffice("Ilian Iliev","0898789789", 9105056565l, "ulica 'purva' nomer 9", ruse, turnovo)).start();
		}
		
	}

}
