#!/bin/sh
set -e

# Initialize Terraform
terraform init

# Apply Terraform changes
terraform apply -auto-approve
