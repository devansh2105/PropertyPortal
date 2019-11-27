package edu.ait.repserver;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
 
import edu.ait.repserver.usecase.entity.Property;
import edu.ait.repserver.usecase.entity.PropertyType;
import edu.ait.repserver.usecase.entity.SaleOrRent;
import edu.ait.repserver.usecase.persistence.PropertyRepository;
 
@Component
public class DemoDataLoader implements CommandLineRunner {
 
	private final PropertyRepository repository;
 
	@Autowired
	public DemoDataLoader(PropertyRepository repository) {
		this.repository = repository;
	}
 
	@Override
	public void run(String... strings) throws Exception {
		repository.save(new Property(PropertyType.HOUSE, SaleOrRent.RENT, 1000d,
				"The most beautiful house is for rent now!", "Debrecen", null, getBytesOf("pictures/house1.jpg")));
		repository.save(new Property(PropertyType.HOUSE, SaleOrRent.SALE, 2000d, "Our house is for sale. It is 200 m2.",
				"Budapest", "Kossuth", getBytesOf("house2.jpg")));
		repository.save(new Property(PropertyType.HOUSE, SaleOrRent.SALE, 3000d,
				"House for sale not far from city center.", "Budapest", "Bartok", getBytesOf("house3.jpg")));
		repository.save(new Property(PropertyType.FLAT, SaleOrRent.RENT, 60d,
				"Flat for rent for 2 years. Brand new furnitures.", "Kolozsvár", "Bartok", getBytesOf("flat1.jpg")));
		repository.save(new Property(PropertyType.FLAT, SaleOrRent.SALE, 2000d, "Flat for sale in Bartok street.",
				"Budapest", "Bartok", getBytesOf("flat2.jpg")));
		repository.save(new Property(PropertyType.HOUSE, SaleOrRent.RENT, 150d, "House for rent immediately.",
				"Szolnok", "Wass", getBytesOf("house3.jpg")));
		repository.save(new Property(PropertyType.FLAT, SaleOrRent.SALE, 1000d, "Big flat for sale in the city center.",
				"Budapest", "Bartok", getBytesOf("house3.jpg")));
		repository.save(new Property(PropertyType.FLAT, SaleOrRent.SALE, 3000d, "Small flat for sale. Reduced price!",
				"Budapest", "Albert", getBytesOf("flat2.jpg")));
		repository.save(new Property(PropertyType.FLAT, SaleOrRent.RENT, 100d,
				"Flat for rent for a single person! Pets are not allowed!", "Budapest", "Bartok", getBytesOf("flat1.jpg")));
		repository.save(new Property(PropertyType.HOUSE, SaleOrRent.RENT, 9000d,
				"Beautiful house for rent for 1 year time.", "Debrecen", "Donath", getBytesOf("house3.jpg")));
	}
 
	private byte[] getBytesOf(String pictureName) throws FileNotFoundException, IOException {
		FileInputStream picStream = new FileInputStream("src/main/resources/" + pictureName);
		byte[] byteOfPicture = readBytes(picStream);
		picStream.close();
		return byteOfPicture;
	}
 
	public static byte[] readBytes(FileInputStream picStream) throws IOException {
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		int b;
		while ((b = picStream.read()) != -1) {
			bos.write(b);
		}
		byte[] byteOfPicture = bos.toByteArray();
		bos.close();
		return byteOfPicture;
		
	}
}