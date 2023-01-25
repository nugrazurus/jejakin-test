# Backend Jejakin
This backend project made using spring boot with Java and Mongo as Database.

### Mongo Collection
---
- Product: 
    - id
    - name
- User:
    - id
    - username
    - firstname
    - lastname
    - email
    - role
- Order:
    - id
    - userId
    - productId
    - amount
    - status
### REST API Endpoint
---
**Product**
| Method   | Uri                    | Description          |
| -------- | ---------------------- | -------------------- |
| `GET`    | `/product`             | Get all product      |
| `GET`    | `/product/{id}`        | Get product by id    |
| `GET`    | `/product/name/{name}` | Get product by name  |
| `POST`   | `/product`             | Create a new product |
| `PUT`    | `/product/{id}`        | Update product by id |
| `DELETE` | `/product/{id}`        | Delete product by id |

**User**
| Method   | Uri                   | Description       |
| -------- | --------------------- | ----------------- |
| `GET`    | `/user`               | Get all user      |
| `GET`    | `/user/{id}`          | Get user by id    |
| `GET`    | `/user/email/{email}` | Get user by email |
| `POST`   | `/user`               | Create a new user |
| `PUT`    | `/user/{id}`          | Update user by id |
| `DELETE` | `/user/{id}`          | Delete user by id |

**Order**
| Method   | Uri                    | Description                   |
| -------- | ---------------------- | ----------------------------- |
| `GET`    | `/order`               | Get all user                  |
| `GET`    | `/order/{id}`          | Get order by id               |
| `GET`    | `/order/user/{userId}` | Get order by userId           |
| `POST`   | `/order`               | Create a new order            |
| `PUT`    | `/order/{id}`          | Update order by id and userId |
| `DELETE` | `/order/{id}/{userId}` | Delete order by id and userId |

