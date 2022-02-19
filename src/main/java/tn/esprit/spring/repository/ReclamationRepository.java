//package tn.esprit.spring.repository;
//
//import java.util.List;
//import java.util.UUID;
//
//import org.springframework.data.cassandra.repository.AllowFiltering;
//import org.springframework.data.cassandra.repository.CassandraRepository;
//
//import com.esprit.travel.model.Reclamation;
//
//public interface ReclamationRepository extends CassandraRepository<Reclamation, UUID> {
//
//	
//	  @AllowFiltering
//	  List<Reclamation> findBydescription(String description);
//	  
//	  List<Reclamation> findBySubject(String subject);
//	
//}
