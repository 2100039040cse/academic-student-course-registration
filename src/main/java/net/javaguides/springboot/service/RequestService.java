package net.javaguides.springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import net.javaguides.springboot.model.Request;
import net.javaguides.springboot.repository.RequestRepository;
import java.util.List;

@Service
public class RequestService {
    @Autowired
    private RequestRepository requestRepository;

    public Request saveRequest(Request request) {
        return requestRepository.save(request);
    }

    public List<Request> getAllRequests() {
        return requestRepository.findAll();
    }

    public void deleteRequest(Long requestId) {
        requestRepository.deleteById(requestId);
    }

    public Request getRequestById(Long requestId) {
        return requestRepository.findById(requestId).orElse(null);
    }
    
    // You can add more service methods as needed
}

