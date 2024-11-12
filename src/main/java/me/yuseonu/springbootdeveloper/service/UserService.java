package me.yuseonu.springbootdeveloper.service;

import lombok.RequiredArgsConstructor;
import me.yuseonu.springbootdeveloper.domain.User;
import me.yuseonu.springbootdeveloper.dto.AddUserRequest;
import me.yuseonu.springbootdeveloper.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor //이걸 사용하면 생성자를 자동으로 생성해주기 때문에 @Autowired 를 사용하지 않아도 됨.
@Service
public class UserService {
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public Long save(AddUserRequest dto) {
        return userRepository.save(User.builder()
                .email(dto.getEmail())
                //패스워드 암호화
                .password(bCryptPasswordEncoder.encode(dto.getPassword()))
                .build()).getId();
    }

    public User findById(Long userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("Unexpected user id:"));
    }
}
