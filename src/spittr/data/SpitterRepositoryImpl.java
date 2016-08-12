package spittr.data;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

@Repository
public class SpitterRepositoryImpl implements SpitterRepository {
	private List<Spitter> list = datas();
	
	
	@Override
	public Spitter save(Spitter unsaved) {
		List<Spitter> resList = list.stream().filter(e -> e.getUsername().equals(unsaved.getUsername())).collect(Collectors.toList());
		if(resList.size()==0){
			Random r = new Random();
			unsaved.setId(r.nextLong());
			list.add(unsaved);
			return unsaved;
		}
		return resList.get(0);
	}

	@Override
	public Spitter findByUsername(String username) {
		List<Spitter> resList = list.stream().filter(e -> e.getUsername().equals(username)).collect(Collectors.toList());
		return resList.size() > 0 ? resList.get(0): new Spitter();
	}
	
	
	private List<Spitter> datas(){
		List<Spitter> spitters = new ArrayList<>();
		Random r = new Random();
		for (long l = 10000; l < 20000; l++) {
			spitters.add(new Spitter(l, "FN" + l, "LN"+l,"username"+l+"@test.com","username"+l,"pwd"+l));
		}
		return spitters;
	}
	

}
