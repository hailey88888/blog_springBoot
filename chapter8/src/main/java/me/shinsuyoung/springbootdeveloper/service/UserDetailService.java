package me.shinsuyoung.springbootdeveloper.service;
import lombok.RequiredArgsConstructor;
import me.shinsuyoung.springbootdeveloper.domain.User;
import me.shinsuyoung.springbootdeveloper.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

// 로그인을 진행할때 사용자 정보를 가져오는 코드 작성
@RequiredArgsConstructor
@Service
public class UserDetailService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public User loadUserByUsername(String email) {
        return userRepository.finaByEmail(email)
                .orElseThrow(() -> new IllegalArgumentException((email)));
    }
}

