package nl.inholland.practiceapi.dao;

import nl.inholland.practiceapi.model.Stock;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StockRepository extends CrudRepository<Stock, Long> {

    Iterable<Stock> getAllByQuantityGreaterThanEqualOrderByQuantity(int minimum);

    Stock getStockByGpu_Id(long Id);

    @Query("select s.quantity * g.clock from Stock s, GPU g where s.gpu.id = g.id and s.gpu.id = ?1")
    int getTotalClockValueOfStockByGpuId(Long id);
}
