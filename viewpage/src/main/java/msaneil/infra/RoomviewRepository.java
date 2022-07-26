package msaneil.infra;

import java.util.List;
import msaneil.domain.*;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "roomviews", path = "roomviews")
public interface RoomviewRepository
    extends PagingAndSortingRepository<Roomview, Long> {
    List<Roomview> findByRsvId(Long rsvId);
    List<Roomview> findByRsvStatus(Integer rsvStatus);
    List<Roomview> findByPayId(Long payId);
    // keep

}
