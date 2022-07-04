package kodlamaio.hrms.entites.dtos;




import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobAdvertisementDto  {
	
	private int id;
	private String companyName;	
	private String jobPositionName;
	private int numberOfOpenPositions;
	private LocalDate applicationDeadline;
	
	
}
