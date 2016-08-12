package spittr.data;

import java.util.List;

import org.springframework.stereotype.Repository;


public interface SpittleRepository {
	List<Spittle> findSpittles(long max, int count);

	Spittle findOne(long spittleId);
}
