# API Reference

## Authentication

### POST /api/auth/signup

Create a new user account.

Request body:
```json
{
  "name": "Jane Doe",
  "email": "jane@example.com",
  "password": "SecurePassword123"
}
```

Response:
```json
{
  "token": "<jwt-token>",
  "email": "jane@example.com",
  "name": "Jane Doe"
}
```

### POST /api/auth/login

Log in with email and password.

Request body:
```json
{
  "email": "jane@example.com",
  "password": "SecurePassword123"
}
```

Response is the same format as signup.

## Products

### GET /api/products

Returns the full product catalog.

### GET /api/products/{id}

Returns a single product by its ID.

### POST /api/products

Create a brand new product.

Requires authentication.

### PUT /api/products/{id}

Update a product by ID.

Requires authentication.

### DELETE /api/products/{id}

Delete a product by ID.

Requires authentication.

## Cart

### POST /api/cart/add

Add an item to the authenticated user's cart.

Request body:
```json
{
  "productId": 1,
  "quantity": 2
}
```

Requires `Authorization: Bearer <token>` header.

### GET /api/cart

Retrieve the authenticated user's cart.

Requires authorization.

### POST /api/cart/clear

Empty the authenticated user's cart.

Requires authorization.

## Orders

### POST /api/orders/create

Create an order for the authenticated user.

Request body example:
```json
{
  "items": [
    { "productId": 1, "title": "T-shirt", "price": 20.0, "quantity": 2 }
  ]
}
```

The backend calculates `totalAmount` from the provided items and assigns the order to the authenticated user.

### GET /api/orders/{id}

Get a single order by ID.

Requires authorization and ownership of the order.

## Payment

### POST /api/payment/create-order

Create a Razorpay order. The backend reads `razorpay.key` and `razorpay.secret` from environment configuration.

Request body:
```json
{
  "amount": 100.0
}
```

### POST /api/payment/verify

Payment signature verification is intentionally left as a placeholder in the current implementation. This endpoint returns `501 Not Implemented`.

### POST /api/payment/create-link

Create a Razorpay payment link.

Request body example:
```json
{
  "amount": 100.0,
  "name": "Jane Doe",
  "email": "jane@example.com",
  "contact": "+911234567890"
}
```

### GET /api/payment/link/{id}

Fetch a payment link by Razorpay payment link ID.

## Monitoring

### GET /actuator/health

Returns health status for the backend service.
