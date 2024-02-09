// Controller


// 



@RestController
public class HelloController {
@Autowired
	private SSNservice ssnService;
@PostMapping("/save")
	SSNResponse saveSSN(@RequestBody SSNRequest ssnRequest){
	return ssnService.saveSSN(ssnRequest);
		
	}
}


//  Service




@Service
public class SSNserviceImpl implements SSNservice {

	@Override
	public SSNResponse saveSSN(SSNRequest ssnRequest) {

		SSNResponse response = new SSNResponse();
		long sn = ssnRequest.getSsn();
		response.setSsn(sn);
		String str = String.valueOf(sn);
		if (str.startsWith("1")) {
			response.setStateName("AP");

		} else if (str.startsWith("2")) {
			response.setStateName("Karnataka");
		} else if (str.startsWith("3")) {
			response.setStateName("Telanagana");

		} else if (str.startsWith("4")) {
			response.setStateName("Tamilnadu");
		}

		return response;
	}
}
