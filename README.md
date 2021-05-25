# workplaying_junx_seoul_heaven

junctionX seoul heaven

## Getting Started

This Project is a Company Game Competition Platform.

A few resources to get you started if this is your first kotlin spring boot project:

- [Spring Boot Guide](https://spring.io/guides/tutorials/spring-boot-kotlin/)

## REST API
- User CRUD [GET, POST, PUT, DELETE] /api/user
  - 모든 User : GET /api/user
  - 특정 User : GET /api/user?id={user_id}
  - User 생성 : GET /api/user
  - User 수정 : PUT /api/user
  - User 삭제 : DELETE /api/user/{user_id}
  
- 대회 신청 [POST] /api/join/user/{user_id}/competition/{competition_id}

- 대회 취소 [POST] /api/cancel/user/{user_id}/competition/{competition_id}

- Competition CRUD [GET, POST, PUT, DELETE] /api/competition
  - 모든 Competition : GET /api/competition
  - 특정 Competition : GET /api/competition?id={competition_id}
  - Competition 생성 : GET /api/competition
  - Competition 수정 : PUT /api/competition
  - Competition 삭제 : DELETE /api/competition/{user_id}
  
- Company CRUD [GET, POST, PUT, DELETE] /api/company
  - 모든 Company : GET /api/company
  - 특정 Company : GET /api/company?id={company_id}
  - Company 생성 : GET /api/company
  - Company 수정 : PUT /api/company
  - Company 삭제 : DELETE /api/company/{company_id}
