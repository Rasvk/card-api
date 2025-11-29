# Cards Service – Design Document

## Table of Contents

1. [Purpose and Scope](#1-purpose-and-scope)
2. [High-Level Architecture](#2-high-level-architecture)
    - [Architecture Diagram](#architecture-diagram)
3. [Domain Model](#3-domain-model)
    - [UML Class Diagram – Domain Layer](#uml-class-diagram--domain-layer)
4. [Persistence Model](#4-persistence-model-database)
    - [Database Schema](#database-schema)
    - [UML Class Diagram – Persistence Layer](#uml-class-diagram--persistence-layer)
5. [Services, Controller and Repositories](#5-services-controller-and-repositories)
    - [UML Class Diagram – Application Layer](#uml-class-diagram--application-layer)
6. [Sequence Diagrams](#6-sequence-diagrams)
    - [Sequence: Create New Shoe](#sequence-create-new-shoe)
    - [Sequence: Draw Card from Shoe](#sequence-draw-card-from-shoe)
7. [API Design](#7-api-design-rest)
8. [Transactions and Concurrency](#8-transactions-and-concurrency)
9. [Future Extensions](#9-future-extensions)

---

## 1. Purpose and Scope

**Purpose**  
Build a Spring Boot–based service that models and exposes an API for:

- Cards (`Card`)
- Decks (`Deck`)
- Shoes (`Shoe` – multiple decks combined, typically used in Blackjack)

The service should support:

- Creating new shoes with a given number of decks
- Shuffling/generating card order
- Drawing cards from a shoe
- Querying how many cards remain in a shoe

**Scope (v1 with database)**

- Use a relational database (e.g., PostgreSQL) to store shoes and cards
- Support multiple shoes in parallel (identified by `shoeId`)
- Provide a simple REST API (no auth in v1)
- Keep the domain model clear and layered

**Out of scope (for now)**

- Full Blackjack game rules engine
- Multiple game sessions per shoe (`Game` model)
- Authentication/authorization
- Advanced distributed scaling
- Multiple different cardgames and rulesets

---

## 2. High-level Architecture

## 3. Domain Model

## 4. Persistence Model

## Services, Controller and Repositories

## 6. Sequence Diagrams

## 7. API Design

## 8. Transactions and Concurrency

## 9. Future Extensions


