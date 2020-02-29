package com.mantra.finance.repository.MGNR.personPost;

import java.util.List;

public interface CustomPersonPostRepository {
    void deletePrevPosts(Long personId, List<Short> deletedOrganIdList);

    void deletePrevPosts(Long personId);


}
