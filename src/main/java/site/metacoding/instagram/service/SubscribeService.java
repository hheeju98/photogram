package site.metacoding.instagram.service;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import site.metacoding.instagram.domain.subscribe.SubscribeRepository;
import site.metacoding.instagram.handler.ex.CustomApiException;

@RequiredArgsConstructor
@Service
public class SubscribeService {

    private final SubscribeRepository subscribeRepository;

    @Transactional // insert, delete를 통해 디비에 영향을 준다.
    public void 구독하기(int fromUserId, int toUserId) {
        try {
            subscribeRepository.mSubscribe(fromUserId, toUserId);
        } catch (Exception e) {
            throw new CustomApiException("이미 구독을 하였습니다.");
        }
    }

    @Transactional
    public void 구독취소하기(int fromUserId, int toUserId) {
        subscribeRepository.mUnsubscribe(fromUserId, toUserId); // m : 내가 만들었다는 뜻
    }
}
