package kr.co.renzo.domain.user.service;

import kr.co.renzo.core.exception.ApiException;
import kr.co.renzo.core.type.ServiceErrorType;
import kr.co.renzo.domain.user.entity.User;
import kr.co.renzo.domain.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User join(User user) {
        return userRepository.save(user);
    }

    public User getByUsername(String username) {
        return userRepository.findByUsername(username)
                .orElseThrow(() -> new ApiException(ServiceErrorType.NOT_FOUND));
    }

    public User save(User user) {
        return userRepository.save(user);
    }

    public User getById(Long userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new ApiException(ServiceErrorType.NOT_FOUND));
    }
}
