package spittr.data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import org.springframework.stereotype.Repository;

@Repository
public class SpittleRepositoryImpl implements SpittleRepository {

	private List<Spittle> list = datas();

	@Override
	public List<Spittle> findSpittles(long max, int count) {

		return createSpittleList(max, count);
	}

	@Override
	public Spittle findOne(long spittleId) {
		if (spittleId < 10000 && spittleId >= 20000)
			spittleId = 10000;
		return list.get((int) (spittleId - 10000));
	}

	private List<Spittle> createSpittleList(long max, int count) {
		return list.subList(0, count);
	}

	private List<Spittle> datas() {
		List<Spittle> spittles = new ArrayList<>();
		Random r = new Random();
		for (long l = 10000; l < 20000; l++) {
			spittles.add(new Spittle(l, "message" + l, new Date(), r.nextDouble() * 100, r.nextDouble() * 100));
		}
		return spittles;
	}
}
